package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static tests.TestBase.BOARD_TITLE;

public class CurrentBoardHelper extends PageBase{

    private String boardName;

    @FindBy(xpath ="//span[@class='placeholder']")
    WebElement addListOption;

    @FindBy(xpath ="//input[@placeholder='Enter list title...']")
    WebElement addTitleField;

    @FindBy(xpath ="//input[@type='submit']")
    WebElement submitListButton;

    @FindBy(xpath ="//a[@class='icon-lg icon-close dark-hover js-cancel-edit']")
    WebElement cancelEditList;

    @FindBy(xpath ="//div[@class = 'list js-list-content']")
    WebElement getList;

    @FindBy(xpath = "//div[@class = 'list js-list-content']")
    List<WebElement> listLists;

    @FindBy(css = "span.js-add-a-card")
    WebElement addCardButton;

    @FindBy(css = "span.js-add-another-card")
    WebElement addAnotherCardButton;

    @FindBy(css = "textarea.list-card-composer-textarea")
    WebElement addTextCurrentCard;

    @FindBy(xpath ="//input[@type='submit'][@value = 'Add Card']")
    WebElement submitCardButton;

    @FindBy(css = "div.card-composer a.icon-close")
    WebElement addEditCardButton;

    @FindBy(css = "a-list-card")
    List<WebElement> listCards;

    public CurrentBoardHelper(WebDriver driver, String boardName) {
        super(driver);
        this.boardName = boardName;
        PageFactory.initElements(driver,this);
    }

    public void openCurrentBoard(){
        WebElement ourBoard = driver.findElement(By.xpath(boardLocator()));
        ourBoard.click();
    }

    public void waitUntilPageIsLoaded(){
        waitUntilElementIsVisible(By.xpath(boardLocator()),20);
        waitUntilElementIsClickable(addListOption, 20);
    }

    private String boardLocator() {

        return "//div[@title = '" + boardName + "']/../..";
    }

    public int getListsQuantity(){
        //List<WebElement> li

        return listLists.size();
    }

    public void createNewList(String title) {
        this.pressCreateNewListButton();
        this.enterTitle(title);
        this.submitAddingList();
        this.cancelFromEditMode();
    }

    private void pressCreateNewListButton() {

        addListOption.click();
        waitUntilElementIsVisible(addTitleField,20);

    }

    public void enterTitle(String title) {

        addTitleField.click();
        addTitleField.sendKeys("Test");
        waitUntilElementIsClickable(submitListButton,30);
    }

    public void submitAddingList() {

        submitListButton.click();
    }

    public void cancelFromEditMode() {
       cancelEditList.click();
    }

    public void enterTextCurrentCard(String card) {
        WebElement textCurrentCard = driver.findElement(By.cssSelector("textarea.list-card-composer-textarea"));
        textCurrentCard.click();
        textCurrentCard.sendKeys(card);
    }

    public boolean existsList() {
        Boolean existsList = false;
        if (driver.findElement(By
                .xpath("//span[@class='placeholder']")).getText().contains("another"))
        {
            existsList = true;
        }
        return  existsList;
    }

    public int receiveQuantityCards() {
        return  driver.findElements(By.cssSelector("a.list-card")).size();
    }

    public void createNewCard(String title) {
        this.defineAddingButton();
        this.enterCardTitle(title);
        this.submitAddCard();
        this.cancelFromEditCardButton();
    }
    public void defineAddingButton() {
         if (addCardButton.isDisplayed()) {
            addCardButton.click();
        }
        else addAnotherCardButton.click();
    }

    public void enterCardTitle(String card) {

        addTextCurrentCard.click();
        addTextCurrentCard.sendKeys(card);
    }

    public void submitAddCard() {

        submitCardButton.click();

    }
    public void cancelFromEditCardButton() {

        addEditCardButton.click();
        waitUntilElementIsNotVisible(addEditCardButton,30);
    }

}
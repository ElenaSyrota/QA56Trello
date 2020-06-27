package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static tests.TestBase.USER_NAME_MENU;

public class ProfilesVisabilityHelper extends PageBase{

    @FindBy (xpath = "//button[@data-test-id = 'header-member-menu-button']")
    WebElement upRightMenu;

    @FindBy (xpath = "//a[@data-test-id = 'header-member-menu-profile']")
    WebElement profileVisabilityMenu;

    @FindBy (xpath = "//button[contains(text(),'Save')]")
    WebElement buttonProfileVisabilityMenu;

    @FindBy (xpath = "//span[contains(text(),'@')]")
    WebElement userNameAfterShtrudel;

    @FindBy (xpath = "//input[@name='username']")
    WebElement userNameField;

    @FindBy (xpath = "//button[@aria-label='Open Member Menu']")
    WebElement menuTextButton;

    public ProfilesVisabilityHelper(WebDriver driver){
        super(driver);
    }

    public void openUpRightMenu() {

        upRightMenu.click();
    }

    public void waitUntilUpRightMenuIsVisible() {

        waitUntilElementIsClickable(profileVisabilityMenu,20);

    }

    public void openProfileVisabilityMenu() {

        profileVisabilityMenu.click();

    }

    public void waitUntilPageIsLoaded() {

        waitUntilElementIsClickable(buttonProfileVisabilityMenu,10);
    }

    public String receiveUserNameAfterShtrudel() {

        return userNameAfterShtrudel.getText();

    }

    public String receiveUserNameFieldUser() {

        return "@"+userNameField.getAttribute("value");
    }

    public String openMemberMenu() {

        menuTextButton.click();
        return menuTextButton.getText();
    }


    private String nameLocator(String nameTitle) {
        return "//div[@title = '" + nameTitle + "']";
    }

    public String nameTextLabel() {
        WebElement nameTextLabel = driver.findElement(By.xpath(nameLocator(USER_NAME_MENU)));
        return nameTextLabel.getText();
    }
}

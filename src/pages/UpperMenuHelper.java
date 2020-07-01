package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpperMenuHelper extends PageBase {
    @FindBy(xpath = "//button[@data-test-id = 'header-member-menu-button']")
    WebElement upperRight;
    @FindBy(xpath = "//ul[@id='search-results']//a[contains(text(),'Getting Started Guide')]")
    WebElement profilevisabilityMenuItem;
    @FindBy(xpath = "//span[contains(text(),'Activity')]/..)[2]")
    WebElement activityMenuItem;
    @FindBy(xpath = "//li[5]//button[1]")
    WebElement helpMenuItem;

    public UpperMenuHelper(WebDriver driver) {
        super(driver);
    }

    public void waitUntilPageIsLoaded(){
        //waitUntilElementIsClickable(profilevisabilityMenuItem,20);
        waitUntilElementIsClickable(activityMenuItem,20);
    }

    public void openProfileVisabilityScreen(){

        profilevisabilityMenuItem.click();
    }

    public void openMenuPage(){
        waitUntilElementIsClickable(upperRight,20);
        upperRight.click();
    }

    public void openActivityPage() {
        activityMenuItem.click();
    }

    public void openHelpPage()
    {
        helpMenuItem.click();
    }
}
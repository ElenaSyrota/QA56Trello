package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilesVisabilityHelper extends PageBase{

    public ProfilesVisabilityHelper(WebDriver driver){
        super(driver);
    }

    public void openUpRightMenu() {
        WebElement upRightMenu = driver.findElement(By.xpath("//button[@data-test-id = 'header-member-menu-button']"));
        upRightMenu.click();
    }

    public void waitUntilUpRightMenuIsVisible() {
        waitUntilElementIsVisible(By.xpath("//a[@data-test-id = 'header-member-menu-profile']"),10);
    }

    public void openProfileVisabilityMenu() {
        WebElement profileVisabilityMenu = driver
                .findElement(By.xpath("//a[@data-test-id = 'header-member-menu-profile']"));
        profileVisabilityMenu.click();
        waitUntilElementIsVisible(By.xpath("//a[@data-test-id = 'header-member-menu-profile']"),10);
    }

    public void waitUntilPageIsLoaded() {
        //waitUntilAllElementsAreVisible(By.xpath("//button[@data-test-id = 'header-member-menu-button']"),20);
        waitUntilElementIsClickable(By.xpath("//button[contains(text(),'Save')]"),10);
    }

    public void receiveUserNameAfterShtrudel() {
        WebElement userNameAfterShtrudel = driver.findElement(By.xpath("//span[contains(text(),'@')]"));

    }

    public void receiveUserNameFieldUser() {
        WebElement userNameField = driver.findElement(By.xpath("//input[@name='username']"));
    }
}

package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BoardsPageHelper;
import pages.LoginPageHelper;
import pages.ProfilesVisabilityHelper;

import java.util.List;

public class ProfilesVisabilityTests extends TestBase {

    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;
    ProfilesVisabilityHelper profilesVisability;

    @BeforeMethod
    public void initTests() throws InterruptedException {
        loginPage= new LoginPageHelper(driver);
        boardsPage= new BoardsPageHelper(driver);
        profilesVisability = new ProfilesVisabilityHelper(driver);
        loginPage.openLoginPage();

        loginPage.loginAsAtlassian(LOGIN,PASSWORD);
        boardsPage.waitUntilPageIsLoaded();

        profilesVisability.openUpRightMenu();
        profilesVisability.waitUntilUpRightMenuIsVisible();
        profilesVisability.openProfileVisabilityMenu();
        profilesVisability.waitUntilPageIsLoaded();

    }

    @Test
    public void lettersIconTest() throws InterruptedException {

        //--- Receive Upper Right Menu element---
        WebElement upRightMenu = driver.findElement(By.xpath("//button[@data-test-id = 'header-member-menu-button']"));
        WebElement upRightMenuText = upRightMenu.findElement(By.xpath(".//span"));

        //--- Receive list of necessary icons ---
        List<WebElement> iconsList = driver.findElements(By.xpath(createLocatorIconlist(USERNAME)));
        System.out.println(iconsList);

        int counter = 0;

        for(WebElement element: iconsList)
            if (element.getText().equals(upRightMenuText.getText()))
               counter++;

        Assert.assertEquals(2,counter, "The text on the upper right icon and on the icon on profile is not the same");

    }

    @Test
    public void userNameDisplayingTest(){

        profilesVisability.receiveUserNameAfterShtrudel();
        profilesVisability.receiveUserNameFieldUser();

        //--- Receive UserName after shtrudel without username value
        WebElement userNameAfterShtrudel = driver.findElement(By.xpath("//span[contains(text(),'@')]"));

        //--- Receive UserName from user name field
        WebElement userNameField = driver.findElement(By.xpath("//input[@name='username']"));

        Assert.assertTrue(userNameAfterShtrudel.getText().contains(USERNAME)&&userNameField.getAttribute("value").equals(USERNAME));
    }


    private String createLocatorIconlist(String username) {
        return "//div[@title='" + username + " (" + username + ")']//span";
    }

}
/*package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfileVisibilityTests extends TestBase {

    @BeforeMethod
    public void initTests() throws InterruptedException {
        driver.findElement(By.linkText("Log In")).click();
        Thread.sleep(5000);

        driver.findElement(By.id("user")).sendKeys(LOGIN);
        Thread.sleep(2000);
        driver.findElement(By.id("login")).click();
        Thread.sleep(10000);

        driver.findElement(By.id("password")).sendKeys(PASSWORD);
        Thread.sleep(2000);
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(25000);

       // System.out.println("'Boards' button text: " + driver
       //         .findElement(By.xpath("//button[@data-test-id='header-boards-menu-button']/span[2]")).getText());
      //  Thread.sleep(3000);

        WebElement menuButton = driver.findElement(By.xpath("//button[@aria-label='Open Member Menu']"));
        menuButton.click();
        Thread.sleep(5000);

        WebElement profileAndVisibilityListItem = driver.findElement(By.xpath("//a[@data-test-id='header-member-menu-profile']"));
        profileAndVisibilityListItem.click();
        Thread.sleep(5000);
    }
    @Test
    public void labelTextVerificationTest() throws InterruptedException {

        WebElement menuTextButton = driver.findElement(By.xpath("//button[@aria-label='Open Member Menu']"));
        System.out.println("Menu button text: " + menuTextButton.getText());
        Thread.sleep(5000);

        WebElement nameTextLabel = driver.findElement(By.xpath(nameLocator(USER_NAME_MENU)));
        System.out.println("Name icon text: " + nameTextLabel.getText());
        Thread.sleep(5000);

        Assert.assertEquals(menuTextButton.getText(),nameTextLabel.getText(),"'Text Menu Button' and 'Text UserName Icon' have a different names");
    }

    @Test
    public void userNameVerificationTest() throws InterruptedException {

        WebElement userNameTextProfile = driver.findElement(By.xpath(userNameTitleLocator(USER_NAME_TITLE)));
        System.out.println("User name Text Profile: "+ userNameTextProfile.getText());
        Thread.sleep(5000);

        WebElement userName = driver.findElement(By.name("username"));
        System.out.println("User name text: @"+ userName.getAttribute("value"));
        Thread.sleep(5000);

        Assert.assertEquals(userNameTextProfile.getText(),"@"+userName.getAttribute("value"),"'User name Profile' and 'User name' have a different names");
    }

    private String nameLocator(String nameTitle) {
        return "//div[@title = '" + nameTitle + "']";
    }

    private String userNameTitleLocator(String userNameProfile) {
        return "//span[contains(text(), '" + USER_NAME_TITLE + "')]/../span[2]";
    }


}*/

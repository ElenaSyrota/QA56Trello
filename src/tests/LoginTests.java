package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BoardsPageHelper;
import pages.LoginPageHelper;

public class LoginTests extends TestBase {

    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;

    @BeforeMethod
    public void initTests(){

        loginPage = PageFactory.initElements(driver, LoginPageHelper.class);
        boardsPage= PageFactory.initElements(driver,BoardsPageHelper.class);
        loginPage.openLoginPage();
    }
    @Test
    public void loginTestPositive()  {

        loginPage.enterLoginAtlassianAndClickLogin(LOGIN);
        loginPage.enterPasswordAtlassianAndClickLogin(PASSWORD);
        boardsPage.waitUntilPageIsLoaded();

        Assert.assertEquals(boardsPage.getButtonBoadrsText(),"Boards", "Text on boardIcon is not 'Boards'");
    }

    @Test
    public void loginNegativeNoLoginNoPassword()  {

        loginPage.pressLoginButton();
        loginPage.waitErrorMessage();

        Assert.assertEquals("Missing email",loginPage.getErrorMessage(),"The text of the message is not 'Missing email'");
    }
    @Test
    public void NegativeLoginIncorrect()  {

        loginPage.enterLoginIncorrect("lena@gmail.com");
        loginPage.clickLoginButton();
        loginPage.waitErrorMessageLoginIncorrect();

       Assert.assertEquals("There isn't an account for this email",loginPage.getErrorMessageLoginIncorrect(),
                "Error message is not correct");
    }
    @Test
    public void NegativePasswordIncorrect() {

        loginPage.enterLoginAtlassianAndClickLogin(LOGIN);
        loginPage.enterPasswordIncorrectAndClickLogin();
        loginPage.waitErrorMessagePasswordIncorrect();

        Assert.assertTrue(loginPage.getErrorMessagePasswordIncorrect().contains("Incorrect email address and / or password."),
               "There is no error message or the text of the message is not correct");
        }
}

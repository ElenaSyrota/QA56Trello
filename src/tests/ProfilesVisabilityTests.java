package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BoardsPageHelper;
import pages.LoginPageHelper;
import pages.ProfileVisabilityHelper;
import pages.UpperMenuHelper;

import java.util.List;

public class ProfilesVisabilityTests extends TestBase {
    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;
    UpperMenuHelper upperMenuPage;
    ProfileVisabilityHelper profileVisabilityPage;

    @BeforeMethod
    public void initTests() throws InterruptedException {
        loginPage = PageFactory.initElements(driver, LoginPageHelper.class);
        boardsPage = PageFactory.initElements(driver, BoardsPageHelper.class);
        upperMenuPage = PageFactory.initElements(driver, UpperMenuHelper.class);
        profileVisabilityPage = PageFactory.initElements(driver, ProfileVisabilityHelper.class);

        loginPage.openLoginPage();
        loginPage.loginAsAtlassian(LOGIN,PASSWORD);
        boardsPage.waitUntilPageIsLoaded();
        upperMenuPage.openMenuPage();
        upperMenuPage.waitUntilPageIsLoaded();
        upperMenuPage.openProfileVisabilityScreen();
        profileVisabilityPage.waitUntilPageIsLoaded();


    }

    @Test
    public void lettersIconTest(){

        Assert.assertTrue(profileVisabilityPage.verifyListIcons(USERNAME), "The text on the upper right icon and on the icon on profile is not the same");
    }

    @Test
    public void userNameDisplayingTest(){

        Assert.assertEquals(profileVisabilityPage.getUserNameAfterShtrudelText(), profileVisabilityPage.getUserNameText(),
                "The text of userName and userNameAfterShtrudel is not the same ");
    }


}
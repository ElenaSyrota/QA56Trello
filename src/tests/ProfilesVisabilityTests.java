package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
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
        loginPage = PageFactory.initElements(driver,LoginPageHelper.class);
        boardsPage = PageFactory.initElements(driver, BoardsPageHelper.class);
        profilesVisability = PageFactory.initElements(driver, ProfilesVisabilityHelper.class);

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
        profilesVisability.openMemberMenu();

        profilesVisability.nameTextLabel();

        Assert.assertEquals(profilesVisability.openMemberMenu(),profilesVisability.nameTextLabel(),"'Text Menu Button' and 'Text UserName Icon' have a different names");

    }


    @Test
    public void userNameDisplayingTest(){

      Assert.assertEquals(profilesVisability.receiveUserNameAfterShtrudel(),
              profilesVisability.receiveUserNameFieldUser(),
              "The text on the upper right icon and on the icon on profile is not the same");
    }

    private String createLocatorIconlist(String username) {
        return "//div[@title='" + username + " (" + username + ")']//span";
    }

}

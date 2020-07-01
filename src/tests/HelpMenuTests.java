package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class HelpMenuTests extends TestBase{
    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;
    CurrentBoardHelper qaHaifa56Page;
    UpperMenuHelper upperMenuPage;
    HelpPageHelper helpPage;

    @BeforeMethod
    public void initTests() throws InterruptedException {

        loginPage = PageFactory.initElements(driver,LoginPageHelper.class);
        boardsPage = PageFactory.initElements(driver, BoardsPageHelper.class);
        qaHaifa56Page = new CurrentBoardHelper(driver, BOARD_TITLE);
        upperMenuPage=PageFactory.initElements(driver, UpperMenuHelper.class);
        helpPage=PageFactory.initElements(driver, HelpPageHelper.class);

        loginPage.openLoginPage();
        loginPage.loginAsAtlassian(LOGIN,PASSWORD);
        boardsPage.waitUntilPageIsLoaded();
        qaHaifa56Page.openCurrentBoard();
        qaHaifa56Page.waitUntilPageIsLoaded();

    }

    @Test
    public void clickHelpInUpRightMenu() {

        upperMenuPage.openMenuPage();
        upperMenuPage.waitUntilPageIsLoaded();
        upperMenuPage.openHelpPage();
        helpPage.waitUntilPageIsLoaded();
        helpPage.clickGettingStartedGuide();
        helpPage.waitUntilNewPageIsLoaded();
        helpPage.newPage();

    }
}

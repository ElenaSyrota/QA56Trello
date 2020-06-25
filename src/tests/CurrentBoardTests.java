package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BoardsPageHelper;
import pages.CurrentBoardQAHaifa56Helper;
import pages.LoginPageHelper;

import java.util.List;

public class CurrentBoardTests extends TestBase{
    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;
    CurrentBoardQAHaifa56Helper qaHaifa56Page;

    @BeforeMethod
    public void initTests() throws InterruptedException {
        loginPage = new LoginPageHelper(driver);
        loginPage = new LoginPageHelper(driver);
        boardsPage = new BoardsPageHelper(driver);
        qaHaifa56Page = new CurrentBoardQAHaifa56Helper(driver);
        loginPage.openLoginPage();
        loginPage.loginAsAtlassian(LOGIN,PASSWORD);
        boardsPage.waitUntilPageIsLoaded();
        qaHaifa56Page.openCurrentBoard();
        qaHaifa56Page.waitUntilPageIsLoaded();

    }

    @Test
    public void createNewList()  {

        //--- Add new list---

        int beforeAdding = qaHaifa56Page.getListsQuantity();
        System.out.println("Lists before adding: " + beforeAdding);
        qaHaifa56Page.createNewList();
        qaHaifa56Page.enterTitle("Test");
        qaHaifa56Page.submitAddingList();
        qaHaifa56Page.cancelFromEditMode();

        int afterAdding = qaHaifa56Page.getListsQuantity();
        System.out.println("Lists after adding: " + afterAdding);

        Assert.assertEquals(afterAdding,beforeAdding+1,
                "The quantity of lists before adding new list is not the same as the quantity after adding");

    }


    @Test
    public void createNewCard() throws InterruptedException {
        Boolean existsList = false;
        if (driver.findElement(By
                .xpath("//span[@class='placeholder']")).getText().contains("another"))
        {
            existsList = true;
        }

        if (!existsList) {
            int beforeAdding = qaHaifa56Page.getListsQuantity();
            System.out.println("Lists before adding: " + beforeAdding);
            qaHaifa56Page.createNewList();
            qaHaifa56Page.enterTitle("Test");
            qaHaifa56Page.submitAddingList();
            qaHaifa56Page.cancelFromEditMode();

            int afterAdding = qaHaifa56Page.getListsQuantity();
            System.out.println("Lists after adding: " + afterAdding);

        }
        //---Receive the quantity of cards ---
        int beforeAdding = driver.findElements(By.cssSelector("a.list-card")).size();

        qaHaifa56Page.defineAddingButton();
        qaHaifa56Page.enterTextCurrentCard();
        qaHaifa56Page.submitAddCard();
        qaHaifa56Page.cancelFromEditCardButton();

        int afterAdding = driver.findElements(By.cssSelector("a.list-card")).size();
        Assert.assertEquals(afterAdding,beforeAdding+1,
                "The quantity of cards before adding new card is not the same as the quantity after adding");

    }
}
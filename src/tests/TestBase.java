package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePageHelper;

public class TestBase {
    WebDriver driver;
    public static final String BOARD_TITLE = "QA Haifa56";
    public static final String LOGIN = "lena.syrota@gmail.com";
    public static final String PASSWORD = "638465Lena";
    public static final String USERNAME = "elenasyrota";
    public static final String USER_NAME_MENU = "Elena Syrota (elenasyrota)";
    HomePageHelper homePage;



    @BeforeMethod
    public void initTestsSuit() throws InterruptedException {
        //---- Enter to the application ---
        driver = new ChromeDriver();
        driver.get("https://trello.com/");
        homePage = PageFactory.initElements(driver,HomePageHelper.class);
        homePage.waitUntilPageIsLoaded();
        waitUntilElementIsClickable(By.linkText("Log In"),20);
    }

    public void waitUntilElementIsClickable(By locator, int time) {

        try {
            new WebDriverWait(driver, time).until(ExpectedConditions
                    .elementToBeClickable(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void waitUntilElementIsVisible(By locator, int time) {

        try {
            new WebDriverWait(driver, time).until(ExpectedConditions
                    .visibilityOfElementLocated(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementIsNotVisible(By locator, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions
                    .elementToBeClickable(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void waitUntilAttributValuesIs(By locator, String attribut, String value, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions
                    .attributeToBe(locator,attribut,value));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilAllElementsAreVisible(By locator, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions
                    .visibilityOfAllElementsLocatedBy(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
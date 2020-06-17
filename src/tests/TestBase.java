package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    WebDriver driver;
    public static final String BOARD_TITLE = "QA Haifa56";
    public static final String LOGIN = "lena.syrota@gmail.com";
    public static final String PASSWORD = "638465Lena";
    public static final String USER_NAME_MENU = "Elena Syrota (elenasyrota)";
    public static final String USER_NAME_TITLE = "Elena Syrota";



    @BeforeMethod
    public void initTestsSuit() throws InterruptedException {
        //---- Enter to the application ---
        driver = new ChromeDriver();
        driver.get("https://trello.com/");
        Thread.sleep(5000);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
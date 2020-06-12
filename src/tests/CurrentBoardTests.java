package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CurrentBoardTests {
    public WebDriver driver;

    @BeforeMethod
    public void iniTests() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.trello.com");
        Thread.sleep(5000);
    }

    @Test
    public void createNewList() throws InterruptedException {



    }
    @Test
    public void createNewCard() throws InterruptedException {



    }

    @AfterMethod
    public void  tearDown(){
        driver.quit();
    }
}

package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests {
    public WebDriver driver;

    @BeforeMethod
    public void iniTests() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.trello.com");
        Thread.sleep(5000);
    }

    @Test
    public void loginTestPositive() throws InterruptedException {

        driver.findElement(By.linkText("Log In")).click();
        Thread.sleep(5000);

        driver.findElement(By.id("user")).sendKeys("lena.syrota@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.id("login")).click();
        Thread.sleep(6000);
        driver.findElement(By.id("password")).sendKeys("638465Lena");
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(25000);
        System.out.println("'Boards' button text: "+ driver
                .findElement(By.xpath("//button[@data-test-id='header-boards-menu-button']/span[2]")).getText());
       Thread.sleep(5000);

    }
    @Test
    public void loginNegativeNoLoginNoPassword() throws InterruptedException {

        driver.findElement(By.linkText("Log In")).click();
        Thread.sleep(5000);

        driver.findElement(By.id("login")).click();
        Thread.sleep(6000);
        System.out.println("Error massage: "+ driver.findElement(By.cssSelector("#error>p")).getText());

    }
    @Test
    public void logInToTrelloEmailNegative() throws InterruptedException {
        WebElement loginButton = driver.findElement(By.xpath("//a[@class='btn btn-sm btn-link text-white']"));
        loginButton.click();
        Thread.sleep(6000);
        driver.findElement(By.cssSelector("input[placeholder='Enter email']")).sendKeys("typl");
        Thread.sleep(6000);
        driver.findElement(By.id("login")).click();
        Thread.sleep(8000);
        System.out.println(driver.findElement(By.id("error")).getText());
        Thread.sleep(6000);
    }
    @Test
    public void logInToTrelloPasswordNegative() throws InterruptedException {
        WebElement loginButton = driver.findElement(By.xpath("//a[@class='btn btn-sm btn-link text-white']"));
        loginButton.click();
        Thread.sleep(6000);
        driver.findElement(By.cssSelector("input[placeholder='Enter email']")).sendKeys("lena.syrota@gmail.com");
        Thread.sleep(6000);
        driver.findElement(By.id("login")).click();
        Thread.sleep(6000);
        driver.findElement(By.cssSelector("input[placeholder='Enter password']")).sendKeys("1111");
        Thread.sleep(6000);
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(6000);
        System.out.println(driver.findElement(By.id("login-error")).getText());
        Thread.sleep(6000);
    }

    @AfterMethod
    public void  tearDown(){
        driver.quit();
    }
}

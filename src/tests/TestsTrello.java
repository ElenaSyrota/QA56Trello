package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestsTrello {
    public WebDriver driver;
    @BeforeMethod
    public void initApp() throws InterruptedException {
        driver=new ChromeDriver();
        driver.get("https://www.trello.com");
        Thread.sleep(5000);
        System.out.println("Title : "+driver.getTitle());
        WebElement loginButton = driver.findElement(By.xpath("//a[@class='btn btn-sm btn-link text-white']"));
        loginButton.click();
        Thread.sleep(6000);

    }
    @Test
    public void logInToTrelloPositive() throws InterruptedException {

        driver.findElement(By.cssSelector("input[placeholder='Enter email']")).sendKeys("lena.syrota@gmail.com");
        Thread.sleep(6000);
        driver.findElement(By.id("login")).click();
        Thread.sleep(6000);
        driver.findElement(By.cssSelector("input[placeholder='Enter password']")).sendKeys("638465Lena");
        Thread.sleep(6000);
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(25000);
        System.out.println(driver.findElement(By.xpath("//span[@class='MEu8ZECLGMLeab']")).getText());
        Thread.sleep(6000);

    }
   @Test
   public void logInToTrelloEmailNegative() throws InterruptedException {
       driver.findElement(By.cssSelector("input[placeholder='Enter email']")).sendKeys("typl");
       Thread.sleep(6000);
       driver.findElement(By.id("login")).click();
       Thread.sleep(8000);
       System.out.println(driver.findElement(By.id("error")).getText());
       Thread.sleep(6000);
   }
    @Test
    public void logInToTrelloPasswordNegative() throws InterruptedException {
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



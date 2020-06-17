package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

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
        Thread.sleep(30000);

        WebElement boardIcon = driver.findElement(By
                .xpath("//button[@data-test-id='header-boards-menu-button']/span[2]"));

        System.out.println("'Boards' button text: "+ boardIcon.getText());
        Thread.sleep(5000);

        Assert.assertEquals("Boards", boardIcon.getText(),"Text on boardIcon is not 'Boards'");
    }
    @Test
    public void loginNegativeNoLoginNoPassword() throws InterruptedException {

        driver.findElement(By.linkText("Log In")).click();
        Thread.sleep(5000);

        driver.findElement(By.id("login")).click();
        Thread.sleep(6000);

        WebElement errorMsg = driver.findElement(By.cssSelector("#error>p"));
        System.out.println("Error massage: "+ errorMsg.getText());

        Assert.assertEquals("Missing email", errorMsg.getText(),"Error!NoLoginNoPassword! ");

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

        WebElement errorMsg1 = driver.findElement(By.id("error"));
        System.out.println(errorMsg1.getText());
        Thread.sleep(6000);

        Assert.assertEquals("There isn't an account for this username", errorMsg1.getText(),"Error! EmailNegative! ");

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

        WebElement errorMsg2 = driver.findElement(By.id("login-error"));
        System.out.println(errorMsg2.getText());
        Thread.sleep(6000);

        Assert.assertEquals("Incorrect email address and / or password.\n" +
                "Do you need help logging in?", errorMsg2.getText(),"Error! PasswordNegative! ");
    }
}

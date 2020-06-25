package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageHelper extends PageBase{
   // WebDriver driver;

    public LoginPageHelper(WebDriver driver){
        super(driver);
    }

    public void openLoginPage(){
        driver.findElement(By.linkText("Log In")).click();
        waitUntilElementIsClickable(By.id("login"),10);
    }

    public void enterLoginAtlassianAndClickLogin(String login) {
        driver.findElement(By.id("user")).sendKeys(login);
        waitUntilAttributValuesIs(By.id("login"), "value", "Log in with Atlassian",10);

        driver.findElement(By.id("login")).click();
        waitUntilElementIsClickable(By.id("login-submit"), 15);
    }

    public void enterPasswordAtlassianAndClickLogin(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-submit")).click();
    }

    public void loginAsAtlassian(String login, String password){
        this.enterLoginAtlassianAndClickLogin(login);
        this.enterPasswordAtlassianAndClickLogin(password);

    }

    public void pressLoginButton() {
        driver.findElement(By.id("login")).click();
    }

    public void waitErrorMessage() {

        waitUntilElementIsVisible(By.cssSelector("#error>p"), 10);
    }
    public String getErrorMessage(){
        WebElement errorMsg = driver.findElement(By.cssSelector("#error>p"));
        return  errorMsg.getText();
    }

    public void enterLoginIncorrect(){
        WebElement loginField = driver.findElement(By.id("user"));
        loginField.sendKeys("lena@gmail.com");

       // driver.findElement(By.id("login")).click();
        //waitUntilElementIsVisible(By.xpath("(//*[@class= 'error-message'])[1]"),20);

    }
    public void waitErrorMessageLoginIncorrect() {
       // WebElement errorMessage = driver.findElement(By.xpath("(//*[class = 'error-message'])[1]"));
        waitUntilElementIsVisible(By.xpath("(//*[class = 'error-message'])[1]"),15);
    }

    public String getErrorMessageLoginIncorrect(){
        WebElement errorMessage = driver.findElement(By.xpath("(//*[class = 'error-message'])[1]"));
       // System.out.println(errorMessage.getText());
        return  errorMessage.getText();
    }

    public void enterPasswordIncorrectAndClickLogin() {

        WebElement passwordLogin = driver.findElement(By.id("password"));
        passwordLogin.sendKeys("error");
        driver.findElement(By.id("login-submit")).click();

        waitUntilElementIsVisible(By.xpath("//div[@id='login-error']/span"),15);

    }

    public void waitErrorMessagePasswordIncorrect() {

        waitUntilAttributValuesIs(By.xpath("//div[@id='login-error']/span"), "value",
                "Log in with Atlassian",10);
    }
    public String getErrorMessagePasswordIncorrect(){
        WebElement errorMessage = driver.findElement(By.xpath("//div[@id='login-error']/span"));
        return  errorMessage.getText();
    }

    public void pressLoginMenuButton() {
        driver.findElement(By.linkText("Log In")).click();
        waitUntilElementIsVisible(By.xpath("//input[@id='login']"),10);
    }
}

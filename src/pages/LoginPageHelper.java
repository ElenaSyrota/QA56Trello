package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageHelper extends PageBase{

    @FindBy(linkText ="Log In")
    WebElement logInIcon;

    @FindBy(id="login")
    WebElement loginButton;

    @FindBy(id="user")
    WebElement userField;

    @FindBy(id="login-submit")
    WebElement loginSubmitButton;

    @FindBy(id="password")
    WebElement passwordField;

    @FindBy(css = "#error>p")
    WebElement noLoginNoPasswordError;

    @FindBy(xpath = "//div[@id ='error']/p")// "(//*[@class='error-message'])[1]")
    WebElement noLoginError;

    @FindBy(xpath = "//div[@id='login-error']/span")
    WebElement noPasswordError;



    public LoginPageHelper(WebDriver driver){
        super(driver);
    }

    public void openLoginPage(){

        logInIcon.click();
        waitUntilElementIsClickable(loginButton,10);
    }

    public void enterLoginAtlassianAndClickLogin(String login) {

        userField.sendKeys(login);
        waitUntilAttributValuesIs(loginButton, "value", "Log in with Atlassian",10);
        loginButton.click();
        waitUntilElementIsClickable(loginSubmitButton, 15);

    }

    public void enterPasswordAtlassianAndClickLogin(String password) {

        passwordField.sendKeys(password);
        loginSubmitButton.click();

    }

    public void loginAsAtlassian(String login, String password){
        this.enterLoginAtlassianAndClickLogin(login);
        this.enterPasswordAtlassianAndClickLogin(password);

    }

    public void pressLoginButton() {

        loginButton.click();
    }

    public void waitErrorMessage() {

       waitUntilElementIsVisible(noLoginNoPasswordError, 40);

    }
    public String getErrorMessage(){

        return  noLoginNoPasswordError.getText();
    }

    public void enterLoginIncorrect(String login){

        userField.sendKeys(login);
        waitUntilElementIsVisible(noLoginError,30);

    }
    public void clickLoginButton() {
        loginButton.click();
    }
    public void waitErrorMessageLoginIncorrect() {

        waitUntilElementIsVisible(noLoginError,30);

    }

    public String getErrorMessageLoginIncorrect(){
        System.out.println(noLoginError.getText());
        return  noLoginError.getText();
    }

    public void enterPasswordIncorrectAndClickLogin() {
        passwordField.sendKeys("error");
        loginSubmitButton.click();
        waitUntilElementIsVisible(noPasswordError,15);

    }

    public void waitErrorMessagePasswordIncorrect() {

        waitUntilAttributValuesIs(noPasswordError, "value",
                "Log in with Atlassian",20);
    }
    public String getErrorMessagePasswordIncorrect(){

        return  noPasswordError.getText();
    }



}

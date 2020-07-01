package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HelpPageHelper extends PageBase {

    @FindBy(xpath = "//ul[@id='search-results']//a[contains(text(),'Getting Started Guide')]")
    WebElement helpItem;

    @FindBy(linkText = "Getting Started Guide")
    WebElement helpGettingStartedGuide;

    @FindBy(xpath = "//div[@class='guide-wrap']//a[1]//img[1]")
    WebElement imgHelp;

    @FindBy(xpath = "//iframe[@class='_3dpJe0xLKraiOf']")
    WebElement frameNameHelp;

    @FindBy(xpath = "//iframe[@class='_3dpJe0xLKraiOf']")
    WebElement buttonNameHelp;


    public HelpPageHelper(WebDriver driver) {
        super(driver);
    }

    public void waitUntilPageIsLoaded() {

        waitUntilElementIsVisible(frameNameHelp,20);

    }

    public void clickGettingStartedGuide()  {

        System.out.println("Current window: "+driver.getWindowHandle());
        driver.switchTo().frame(frameNameHelp);
        helpGettingStartedGuide.click();

    }

    public void waitUntilNewPageIsLoaded() {

        waitUntilElementIsVisible(imgHelp, 20);
        //waitUntilAllElementsAreVisible(activityRecordsList,30);

    }

    public void newPage() {

        String firstWindow = driver.getWindowHandle();
        System.out.println("Current window: "+driver.getWindowHandle());
        String secondWindow = "";
        for (String uId: driver.getWindowHandles()) {
            if(!uId.equals(firstWindow))  secondWindow= uId;
        }
        driver.switchTo().window(secondWindow);
        System.out.println("Current new window: "+driver.getWindowHandle());
        System.out.println("Text: "+driver.findElement(By.xpath("//h1[contains(text(),'Getting Started With Trello')]")).getText());
        driver.close();
        driver.switchTo().window(firstWindow);
    }
}

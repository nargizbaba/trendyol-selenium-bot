package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class BasePage {

    public static WebDriver driver;

    public WebDriverWait wait;
    public JavascriptExecutor js;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    //helpers
    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement acceptCookiesButton;

    public void acceptCookies(){
        try {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesButton));
            button.click();
        } catch (Exception e) {
            System.out.println("Cookie button not found or already accepted.");
        }
    }

    public void waitAndClick(WebElement element) {
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(element));

            element.click();
        } catch(RuntimeException e){
            System.out.println("Element not found: " + e.getMessage());
        }
    }

    public void switchToTab(int tabNum){
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabNum));
    }

    public void fillFieldAndSubmit(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
        element.sendKeys(Keys.RETURN);
    }

    public void closeAd() throws InterruptedException {
        Thread.sleep(2000);
        new Actions(driver).moveByOffset(10,10).click().perform();
    }

    public void fillField(WebElement webElement, String value) {
        webElement.sendKeys(value);
    }
}

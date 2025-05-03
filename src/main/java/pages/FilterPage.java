package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilterPage extends BasePage{

    public FilterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[data-testid='suggestion']")
    private WebElement search;

    @FindBy(xpath = "//a[contains(@href, '/sr?q=watch&qt=watch&st=watch&lc=1240&os=1')]")
    private WebElement filterTheType;

    @FindBy(xpath = "//a[@href='/sr?wb=101470&lc=1240&q=watch&qt=watch&st=watch&os=1']")
    private WebElement brand;

    @FindBy(xpath = "//div[contains(@class, 'fltr-cntnr-ttl') and text()='Renk']")
    private WebElement color;

    @FindBy(xpath = "//a[@title='Beyaz']")
    private WebElement greenEl;

    public void search() throws InterruptedException {
        Thread.sleep(3000);
        fillFieldAndSubmit(search, "watch");
    }

    public void filterWatchType() throws InterruptedException {
        filterTheType.click();
        Thread.sleep(2000);
    }

    public void chooseBrand() throws InterruptedException {
        brand.click();
        Thread.sleep(2000);
    }

    private void scrollToColor(){
        WebElement colorElement = driver.findElement(By.xpath("//div[contains(text(), 'Renk')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", colorElement);
    }

    public void chooseColor() throws InterruptedException {
        scrollToColor();

        color.click();
        Thread.sleep(2000);
        greenEl.click();
    }
}

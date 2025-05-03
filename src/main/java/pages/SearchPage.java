package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"sfx-discovery-search-suggestions\"]/div/div/input")
    private WebElement search;

    @FindBy(xpath = "(//div[contains(@class, 'p-card-wrppr')])[1]")
    public WebElement firstGloveProduct;

    @FindBy(xpath = "//div[@class='sp-itm' and text()='8 oz']")
    public WebElement choosingSize;

    public void search() {
        waitAndClick(search);
        fillFieldAndSubmit(search, "gloves");
    }

    public void clickFirstGlove() {
        firstGloveProduct.click();
    }

    public void selectSize() {
        choosingSize.click();
    }
}

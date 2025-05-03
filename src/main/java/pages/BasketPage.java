package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends BasePage {

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@class='add-to-basket']//div[text()='Sepete Ekle']")
    private WebElement addToBasket;

    @FindBy(xpath = "//a[@class='link account-basket']//p[text()='Sepetim']")
    private WebElement accountBasket;

    @FindBy(css = "a.redirect-to-basket")
    private WebElement redirectToBasket;

    @FindBy(css = "a.go-basket-button")
    private WebElement goBasket;

    @FindBy(xpath = "//button[@aria-label='Ürün adedi arttırma']")
    private WebElement increasing;

    public void addToBasket(){
        addToBasket.click();
        redirectToBasket.click();
        accountBasket.click();
    }

    public void goToBasketPage(){
        goBasket.click();
    }

    public void increaseAmount() {
        waitAndClick(increasing);
    }
}
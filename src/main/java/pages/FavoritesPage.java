package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FavoritesPage extends BasePage {

    public FavoritesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"sfx-discovery-search-suggestions\"]/div/div/input")
    private WebElement search;

    @FindBy(xpath ="(//a[contains(@class, 'p-card-chldrn-cntnr card-border')])[1]")
    private WebElement desiredItem;

    @FindBy(xpath = "//div[@class='tooltip-indicator']//button[@class='fv']")
    private WebElement favoriteButton;

    @FindBy(xpath = "//div[@class='link']//p[text()='Favorilerim']")
    private WebElement favoritesIcon;

    public void search() {
        fillFieldAndSubmit(search, "parfume");
    }

    public void clickDesiredItem(){
        desiredItem.click();
    }

    public void openFavoritesPage(){
        favoritesIcon.click();
    }

    //helpers
    public void addToFavorites(int tabNum) throws InterruptedException {
        switchToTab(tabNum);

        var favoriteIcon = favoriteButton.findElements(By.className("i-heart-orange"));

        //favorite icon is not clicked
        if(favoriteIcon.isEmpty()){
            favoriteButton.click();
        }
        Thread.sleep(2000);
    }
}
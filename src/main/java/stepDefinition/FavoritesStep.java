package stepDefinition;

import config.WebDriverManager;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.FavoritesPage;

public class FavoritesStep {

    public static FavoritesPage favoritesPage;
    public static WebDriver driver;

    @Given("the user searches for a desired item")
    public void searchDesiredItem() {
        driver = WebDriverManager.getDriver();
        favoritesPage = new FavoritesPage(driver);
        favoritesPage.search();
    }

    @When("the user clicks on the desired item")
    public void clickDesiredItem() {
        favoritesPage.clickDesiredItem();
    }

    @And("the user adds the item to favorites")
    public void addToFavorites() throws InterruptedException {
        favoritesPage.addToFavorites(2);
    }

    @Then("the user clicks on the favorite button and sees the products there")
    public void goToFavoritesPage(){
        favoritesPage.openFavoritesPage();
    }
}
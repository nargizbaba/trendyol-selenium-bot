package stepDefinition;

import config.WebDriverManager;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.BasketPage;

public class BasketStep {

    public static BasketPage basketPage;
    public static WebDriver driver;

    @Given("after choosing desired product the user clicks on add to basket button")
    public void addToBasket() {
        driver = WebDriverManager.getDriver();
        basketPage = new BasketPage(driver);
        basketPage.addToBasket();
    }

    @When("the user clicks on the basket button and sees the product there")
    public void goToBasket() {
        basketPage.goToBasketPage();
    }

    @Then("the user decreases the amount of the item selected")
    public void decreaseAmount() {
        basketPage.increaseAmount();
    }
}
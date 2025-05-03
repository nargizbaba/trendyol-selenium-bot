package stepDefinition;

import config.WebDriverManager;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.FilterPage;

public class FilterStep {

    public static FilterPage filterPage;
    public static WebDriver driver;

    @Given("The user searches for an item")
    public void searchingItem() throws InterruptedException {
        driver = WebDriverManager.getDriver();
        filterPage = new FilterPage(driver);
        filterPage.search();
    }
    @When("The user searches for categories of the item")
    public void searchWatchType() throws InterruptedException {
        filterPage.filterWatchType();
    }
    @When("The user searches for the brand of the item")
    public void filterByBrand() throws InterruptedException {
        filterPage.chooseBrand();
    }

    @Then("The user decides on the color")
    public void chooseColor() throws InterruptedException {
        filterPage.chooseColor();
    }
}
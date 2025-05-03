package stepDefinition;

import config.WebDriverManager;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.SearchPage;

import java.util.ArrayList;

public class SearchStep {
    public static SearchPage searchPage;
    public static WebDriver driver;

    @Given("the user clicks on search button")
    public void clickSearchIcon() {
        driver = WebDriverManager.getDriver();
        searchPage = new SearchPage(driver);
        searchPage.search();
    }

    @When("the user searches for gloves")
    public void searchGloves() {
        driver.get("https://www.trendyol.com/sr?q=gloves&qt=gloves&st=gloves&lc=145668&os=1");
    }

    @And("the user clicks on the desired product")
    public void clickItem() throws InterruptedException {
        searchPage.clickFirstGlove();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        searchPage.closeAd();
    }

    @Then("the user chooses its size")
    public void chooseSize(){
        searchPage.selectSize();
    }
}
package stepDefinition;

import config.WebDriverManager;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginStep {
    public LoginPage loginPage;
    public WebDriver driver;

    @Given("the user is on the Trendyol homepage")
    public void goToHomePage() {
        driver = WebDriverManager.getDriver();
        loginPage = new LoginPage(driver);

        String firstPage = "https://www.trendyol.com/";
        driver.get(firstPage);
        driver.manage().window().maximize();
    }

    @And("the user clicks on countries' button and selects Turkey option")
    public void chooseCountry() throws InterruptedException {
        loginPage.acceptCookies();
        loginPage.closeAd();
        loginPage.chooseCountry();
        Thread.sleep(5000);
    }

    @When("the user clicks on Login and login button")
    public void openLoginPage() {
        loginPage.openLoginPage();
    }
    @And("the user writes email and password")
    public void fillCredentials() {
        loginPage.fillCredentials();
    }
    @And("the user clicks on login button and redirected to homepage")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }
}

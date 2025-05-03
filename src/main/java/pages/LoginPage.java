package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(className = "country")
    private WebElement country;

    @FindBy(xpath = "//*[@id=\"header\"]/header/section[1]/div/div/div[2]/section/li")
    private WebElement countrySection;

    @FindBy(xpath = "//*[@id=\"header\"]/header/section[1]/div/div/div[2]/section/ul/li[1]")
    private WebElement Turkey;

    @FindBy(xpath = "//*[@id=\"header\"]/header/section[1]/div/div/div[2]/button")
    private WebElement save;

    @FindBy(xpath = "//*[@id=\"account-navigation-container\"]/div/div[1]/div[1]")
    private WebElement loginIcon;

    @FindBy(xpath = "//*[@id=\"login-email\"]")
    private WebElement email;

    @FindBy(xpath = "//*[@id=\"login-password-input\"]")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"login-register\"]/div[3]/div[1]/form/button")
    private WebElement loginButton;

    public void chooseCountry(){
        country.click();
        countrySection.click();
        Turkey.click();
        save.click();
    }

    public void openLoginPage() {
        loginIcon.click();
    }

    public void fillCredentials() {
        fillField(email, "john.doe@example.com");
        fillField(password, "123456789");
    }

    public void clickLoginButton(){
        loginButton.click();
    }
}

package my.project.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {
    private SelenideElement usernameLocator = $("#mat-input-0");
    private SelenideElement passwordLocator = $("#mat-input-1");
    private SelenideElement logInButtonLocator = $(".mat-button-wrapper");
    private SelenideElement loginHeader = $("h2");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage setUserName(String username) {
        usernameLocator.clear();
        usernameLocator.sendKeys(username);
        return this;
    }

    public LoginPage setPassword(String password) {
        passwordLocator.clear();
        passwordLocator.sendKeys(password);
        return this;
    }

    public LoginPage clickOnLogInButton() {
        clickButton(logInButtonLocator);
        return this;
    }

    public String getLoginHeader() {
        return loginHeader.getText();
    }
}





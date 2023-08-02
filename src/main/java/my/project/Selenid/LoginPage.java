package my.project.Selenid;


import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement usernameLocator = $("#mat-input-0");
    private SelenideElement passwordLocator = $("#mat-input-1");
    private SelenideElement logInButtonLocator = $(".mat-button-wrapper");
    private SelenideElement loginHeader = $("h2");

    public LoginPage() {
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

    public ProfilePage clickOnLogInButton() {
        logInButtonLocator.click();
        return new ProfilePage();
    }

    public String getLoginHeader() {
        return loginHeader.getText();
    }
}
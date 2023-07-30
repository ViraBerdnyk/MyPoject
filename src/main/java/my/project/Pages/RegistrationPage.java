package my.project.Pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage  {
    private SelenideElement usernameLocator = $("input[formcontrolname='username']");
    private SelenideElement nameLocator = $("input[formcontrolname='name']");
    private SelenideElement lastnameLocator = $("input[formcontrolname='lastname']");
    private SelenideElement passwordLocator = $("input[formcontrolname='password']");
    private SelenideElement confirmPassLocator = $("input[formcontrolname='confirmPassword']");
    private SelenideElement registerButton = $("span.mat-button-wrapper");

    private SelenideElement signInButton = $("a[href='/login']");
    private SelenideElement registrationHeader = $("h2");

    public RegistrationPage() {
    }

    public RegistrationPage setUserName(String username) {
        usernameLocator.clear();
        usernameLocator.sendKeys(username);
        return this;
    }

    public RegistrationPage setName(String name) {
        nameLocator.clear();
        nameLocator.sendKeys(name);
        return this;
    }

    public RegistrationPage setLastname(String lastname) {
        lastnameLocator.clear();
        lastnameLocator.sendKeys(lastname);
        return this;
    }

    public RegistrationPage setPasswordAndConfirm(String password) {
        passwordLocator.clear();
        passwordLocator.sendKeys(password);
        confirmPassLocator.clear();
        confirmPassLocator.sendKeys(password);
        return this;
    }

    public RegistrationPage clickOnRegisterButton() {
        registerButton.click();
        return this;
    }

    public LoginPage clickOnSignInButton() {
        signInButton.click();
        return new LoginPage();
    }

    public String getTitle() {
        return registrationHeader.getText();
    }
}
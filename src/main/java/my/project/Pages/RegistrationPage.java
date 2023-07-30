package my.project.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage extends BasePage {
    private SelenideElement usernameLocator = $("input[formcontrolname='username']");
    private SelenideElement nameLocator = $("input[formcontrolname='name']");
    private SelenideElement lastnameLocator = $("input[formcontrolname='lastname']");
    private SelenideElement passwordLocator = $("input[formcontrolname='password']");
    private SelenideElement confirmPassLocator = $("input[formcontrolname='confirmPassword']");
    private SelenideElement registerButton = $("span.mat-button-wrapper");

    private SelenideElement signInButton = $("a[href='/login']");
    private SelenideElement registrationHeader = $("h2");

    public RegistrationPage(WebDriver driver) {
        super(driver);
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
        clickButton(registerButton);
        return this;
    }

    public LoginPage clickOnSignInButton() {
        clickButton(signInButton);
        return new LoginPage(driver);
    }

    public String getTitle() {
        return registrationHeader.getText();
    }
}
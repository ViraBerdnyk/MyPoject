package my.project.Pages;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import static com.codeborne.selenide.Selenide.$;


public class WelcomePage extends BasePage {
    private SelenideElement loginLocator = $("a[href='/login']");
    private SelenideElement createAccountLocator = $("a[href='/register']");

    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickLogInButton() {
        clickButton(loginLocator);
        return new LoginPage(driver);
    }

    public RegistrationPage clickCreateAccountButton() {
        clickButton(createAccountLocator);
        return new RegistrationPage(driver);
    }
}


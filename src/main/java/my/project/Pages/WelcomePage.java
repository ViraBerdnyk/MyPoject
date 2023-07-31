package my.project.Pages;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class WelcomePage  {
    private final SelenideElement loginLocator = $("a[href='/login']");
    private final SelenideElement createAccountLocator = $("a[href='/register']");

    public WelcomePage() {
        open("https://freelance.lsrv.in.ua");
    }

    public LoginPage clickLogInButton() {
        loginLocator.click();
        return new LoginPage();
    }

    public RegistrationPage clickCreateAccountButton() {
        createAccountLocator.click();
        return new RegistrationPage();
    }
}
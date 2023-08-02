package my.project.Selenid;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;


public class WelcomePage  {
    private final SelenideElement loginLocator = $("a[href='/login']");
    private final SelenideElement createAccountLocator = $("a[href='/register']");



    public LoginPage clickLogInButton() {
        loginLocator.click();
        return new LoginPage();
    }

    public RegistrationPage clickCreateAccountButton() {
        createAccountLocator.click();
        return new RegistrationPage();
    }
}


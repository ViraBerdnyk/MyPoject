package my.project.Selenid;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class BasePage {
    protected SelenideElement clickButton(SelenideElement button) {
        button.click();
        return button;
    }

    public LoginPage navigateToLoginPage() {
        clickButton($("a[href='/login']"));
        return page(LoginPage.class);
    }

    public WelcomePage navigateToWelcomePage() {
        clickButton($("a[href='/']"));
        return page(WelcomePage.class);
    }
}


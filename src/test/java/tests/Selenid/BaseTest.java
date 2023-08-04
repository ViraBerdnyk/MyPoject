package tests.Selenid;

import com.codeborne.selenide.Configuration;
import my.project.Selenid.LoginPage;
import my.project.Selenid.ProfilePage;
import my.project.Selenid.WelcomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import tests.listeners.CustomExtentReportsListener;

import static com.codeborne.selenide.Selenide.open;
@Listeners({CustomExtentReportsListener.class})
public class BaseTest {

    @BeforeClass
    public void setUp() {
        Configuration.browserSize = "1920x1080";
    }

    public ProfilePage loginAsTom() {
        WelcomePage welcomePage = open("https://freelance.lsrv.in.ua/profile", WelcomePage.class);
        LoginPage loginPage = welcomePage.clickLogInButton();
        return loginPage.setUserName("Tom")
                .setPassword("12345678")
                .clickOnLogInButton();

    }

}

package tests.Wd;
import my.project.Pages.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.open;



public class LoginTest {

    @BeforeClass
    public void setUp() {

        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void loginTest() {
        open("https://freelance.lsrv.in.ua/login"); // Відкрити сторінку входу

        LoginPage loginPage = new LoginPage();
        loginPage.setUserName("Tom")
                .setPassword("12345678")
                .clickOnLogInButton();
    }
}
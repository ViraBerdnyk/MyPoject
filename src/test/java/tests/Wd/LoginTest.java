package tests.Wd;

import my.project.Pages.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.open;


public class LoginTest extends BaseTest {



    @Test
    public void loginTest() {
        loginAsTom();
    }
}
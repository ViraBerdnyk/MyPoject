package tests.Wd;

import my.project.Pages.RegistrationPage;
import my.project.Pages.WelcomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.codeborne.selenide.Configuration;

public class RegistrationTest {

    @Test
    public void registrationTest() {
        WelcomePage welcomePage = new WelcomePage();
        RegistrationPage registrationPage = welcomePage.clickCreateAccountButton(); // Перехід до сторінки реєстрації

        registrationPage.setUserName("Tom")
                .setName("Tom")
                .setLastname("Smit")
                .setPasswordAndConfirm("12345678")
                .clickOnRegisterButton()
                .clickOnSignInButton();
    }
}
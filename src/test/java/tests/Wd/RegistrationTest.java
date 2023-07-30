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
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://freelance.lsrv.in.ua");
    }

    @Test
    public void registrationTest() {
        WelcomePage welcomePage = new WelcomePage(driver);
        RegistrationPage registrationPage = welcomePage.clickCreateAccountButton();

        registrationPage.setUserName("Tom")
                .setName("Tom")
                .setLastname("Smit")
                .setPasswordAndConfirm("12345678")
                .clickOnRegisterButton()
                .clickOnSignInButton();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
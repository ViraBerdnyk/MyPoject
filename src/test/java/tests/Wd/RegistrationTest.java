package tests.Wd;

import my.project.Pages.RegistrationPage;
import my.project.Pages.WelcomePage;
import org.testng.annotations.Test;


public class RegistrationTest {

    @Test
    public void registrationTest() {
        WelcomePage welcomePage = new WelcomePage();
        RegistrationPage registrationPage = welcomePage.clickCreateAccountButton();

        registrationPage.setUserName("Tom")
                .setName("Tom")
                .setLastname("Smit")
                .setPasswordAndConfirm("12345678")
                .clickOnRegisterButton()
                .clickOnSignInButton();
    }
}
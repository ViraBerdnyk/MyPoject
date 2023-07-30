package tests.Wd;


import com.codeborne.selenide.Configuration;
import my.project.Pages.EditUserProfilePopup;
import my.project.Pages.LoginPage;
import my.project.Pages.ProfilePage;
import my.project.Pages.WelcomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertEquals;

public class ProfileTest {
    @BeforeClass
    public void setUp() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void profileTest() {
        WelcomePage welcomePage = open("https://freelance.lsrv.in.ua/profile", WelcomePage.class);
        LoginPage loginPage = welcomePage.clickLogInButton();
        loginPage.setUserName("Tom")
                .setPassword("12345678")
                .clickOnLogInButton();

        ProfilePage profilePage = new ProfilePage();
        profilePage.clickOnProfileDropdownButton();
        profilePage.clickOnProfileMenuItem();
        EditUserProfilePopup editPopup = profilePage.clickOnEditInfo();
        editPopup.setName("John")
                .setLastname("Doe")
                .clickOnUpdateButton();


        assertEquals(profilePage.getUserFullName(), "John Doe");
    }
}
package tests.Wd;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import my.project.Pages.AddJobPage;
import my.project.Pages.LoginPage;
import my.project.Pages.ProfilePage;
import my.project.Pages.WelcomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import tests.listeners.CustomExtentReportsListener;

import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertTrue;

@Listeners({CustomExtentReportsListener.class})
public class CreateJobListingTest {

    @BeforeClass
    public void setUp() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void createJobListingTest() {
        WelcomePage welcomePage = open("https://freelance.lsrv.in.ua/profile", WelcomePage.class);
        LoginPage loginPage = welcomePage.clickLogInButton();
        ProfilePage profilePage = loginPage.setUserName("Tom")
                .setPassword("12345678")
                .clickOnLogInButton();

        profilePage.clickOnProfileDropdownButton();
        profilePage.clickOnProfileMenuItem();

        // Create a new job listing
        AddJobPage addJobPage = new AddJobPage();
        String jobTitle = "New Job Listing";
        String jobDescription = "This is a test job listing.";
        double jobPrice = 100.0;
        profilePage = addJobPage.addNewJob(jobTitle, jobDescription, jobPrice);


        assertTrue(profilePage.isJobDisplayedInMyJobs(jobTitle));
    }
}
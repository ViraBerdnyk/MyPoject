package tests.Wd;
import com.codeborne.selenide.Selenide;
import my.project.Pages.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.codeborne.selenide.Configuration;
import tests.listeners.CustomExtentReportsListener;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.*;

import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertTrue;

@Listeners({CustomExtentReportsListener.class})
public class ViewJobDetailsAndLeaveCommentTest {


    @BeforeClass
    public void setUp() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void viewAndCommentJobListingTest() {

            WelcomePage welcomePage = open("https://freelance.lsrv.in.ua/profile", WelcomePage.class);
            LoginPage loginPage = welcomePage.clickLogInButton();
            loginPage.setUserName("Tom")
                    .setPassword("12345678")
                    .clickOnLogInButton();

        WelcomePage mainPage = open("https://freelance.lsrv.in.ua/main", WelcomePage.class);


        JobDetailsPage jobDetailsPage = mainPage.clickOnJobListing(1);


        jobDetailsPage.getViewInfoButton().shouldBe(visible);


        jobDetailsPage.getViewInfoButton().click();


        String commentText = "This is a test comment.";
        jobDetailsPage.addComment(commentText);


        assertTrue(jobDetailsPage.isCommentDisplayed(commentText));
    }
}
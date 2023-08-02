package tests.Selenid;

import com.codeborne.selenide.SelenideElement;
import my.project.Selenid.JobDetailsPage;
import my.project.Selenid.ProfilePage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class UserJobManagementTest extends BaseTest {

    @Test
    public void userCanLoginAndViewAndDeleteJobs() {
        ProfilePage profilePage = loginAsTom();

        profilePage.clickOnProfileDropdownButton();
        profilePage.clickOnProfileMenuItem();

        JobDetailsPage jobDetailsPage = profilePage.clickViewInfoButton();
        int commentsNumber = jobDetailsPage.getCommentsNumber();
        assertEquals(commentsNumber, 5);

        SelenideElement scrollJobs = $x("//app-my-jobs");
        SelenideElement removeJob = $x("//mat-icon[@class='mat-icon notranslate mat-warn material-icons']");

        scrollJobs.scrollTo();

        removeJob.shouldBe(visible).click();

        String jobTitle = "New Job Listing";
        assertTrue(!profilePage.isJobDisplayedInMyJobs(jobTitle));
    }
}




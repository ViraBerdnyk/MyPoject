package tests.Selenid;

import my.project.Selenid.AddJobPage;
import my.project.Selenid.ProfilePage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CreateJobListingTest extends BaseTest {

    @Test
    public void createJobListingTest() {
        ProfilePage profilePage = loginAsTom();

        profilePage.clickOnProfileDropdownButton();
        profilePage.clickOnProfileMenuItem();
        profilePage.clickOnAddJobButton();
        AddJobPage addJobPage = new AddJobPage();
        String jobTitle = "New Job Listing";
        String jobDescription = "This is a test job listing.";
        double jobPrice = 100.0;
        profilePage = addJobPage.addNewJob(jobTitle, jobDescription, jobPrice);

        assertTrue(profilePage.isJobDisplayedInMyJobs(jobTitle));
    }
}
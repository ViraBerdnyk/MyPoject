package tests.Selenid;

import my.project.Selenid.*;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertTrue;

public class UserInteractionTest extends BaseTest {

    @Test
    public void userCanLoginAndViewJobDetailsAndComment() {
        ProfilePage profilePage = loginAsTom();

        JobDetailsPage jobDetailsPage = profilePage.clickViewInfoButton();

        String commentText = "This is a test comment.";
        jobDetailsPage.addComment(commentText);

        assertTrue(jobDetailsPage.isCommentDisplayed(commentText));
    }
}




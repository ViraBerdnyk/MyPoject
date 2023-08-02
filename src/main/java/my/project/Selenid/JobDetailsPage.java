package my.project.Selenid;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class JobDetailsPage {


    private final SelenideElement postedBy = $("div.mat-card-header-text>.mat-card-subtitle");
    private final SelenideElement commentsNumber = $("mat-card>:nth-child(2)");
    private SelenideElement commentInput = $x("//textarea[@formcontrolname='message']");
    private SelenideElement leaveCommentButton = $x("//span[text()=' Leave comment ']");
    private SelenideElement closeJobDetailsButton = $x("//span[text()='Close job details']");
    private SelenideElement createdComment = $x("//div[@class='comments']//mat-card-content[@class='mat-card-content']/p");

    public JobDetailsPage addComment(String commentText) {
        commentInput.setValue(commentText);
        leaveCommentButton.click();
        return this;
    }

    public boolean isCommentDisplayed(String commentText) {
        return createdComment.getText().equals(commentText);
    }

    public String getPostedBy() {
        return postedBy.getText();
    }

    public int getCommentsNumber() {
        String commentsNumberAsString = commentsNumber.getText().split(" ")[1];
        return Integer.parseInt(commentsNumberAsString);
    }

}

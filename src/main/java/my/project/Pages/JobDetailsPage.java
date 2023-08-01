package my.project.Pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class JobDetailsPage {
    private final SelenideElement viewInfoButton = $("mat-card-actions button");
    private final SelenideElement commentInput = $("input[formcontrolname='comment']");
    private final SelenideElement addCommentButton = $("button[type='submit']");
    private final SelenideElement commentSection = $(".comments");

    public boolean isJobDetailsPageDisplayed() {
        return viewInfoButton.is(Condition.visible);
    }

    public SelenideElement getViewInfoButton() {
        return viewInfoButton;
    }

    public void clickViewInfoButton() {
        viewInfoButton.click();
    }

    public void addComment(String commentText) {
        commentInput.setValue(commentText);
        addCommentButton.click();
    }

    public boolean isCommentDisplayed(String commentText) {
        return commentSection.$x("//span[contains(text(), '" + commentText + "')]").is(Condition.visible);
    }

}
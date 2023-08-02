package my.project.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class AddJobPage {

        private final SelenideElement formTitle = $("app-add-job h2");
        private final SelenideElement titleInput = $("input[formcontrolname='title']");
        private final SelenideElement descriptionInput = $("textarea[formcontrolname='description']");
        private final SelenideElement priceInput = $("input[formcontrolname='price']");
        private final SelenideElement addJobButton = $x("//span[text()=' Create job ']/parent::button");

        public String getFormTitle() {
            return formTitle.getText();
        }

        public AddJobPage setJobTitle(String title) {
            titleInput.clear();
            titleInput.sendKeys(title);
            return this;
        }

        public AddJobPage setJobDescription(String description) {
            descriptionInput.clear();
            descriptionInput.sendKeys(description);
            return this;
        }

        public AddJobPage setJobPrice(Double price) {
            priceInput.clear();
            priceInput.sendKeys(String.valueOf(price));
            return this;
        }

        public ProfilePage clickAddJobButton() {
            addJobButton.$(".mat-button-wrapper").click();
            return new ProfilePage();
        }

        public ProfilePage addNewJob(String title, String description, Double price) {
            return setJobTitle(title)
                    .setJobDescription(description)
                    .setJobPrice(price)
                    .clickAddJobButton();
        }
    }

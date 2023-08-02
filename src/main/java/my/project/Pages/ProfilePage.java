package my.project.Pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class ProfilePage {
    private final SelenideElement profileTitle = $("h1");
    private final SelenideElement username = $(".col h2");
    private final SelenideElement userFullName = $(".col h3");
    private final SelenideElement profileDropdownButton = $x("//button[@mattooltip='Profile']");
    private final SelenideElement editInfoButton = $x("//span[text()='Edit Info'] /parent::button");
    private final SelenideElement closeProfileButton = $x("//span[text()='Close profile'] /parent::button");
    private final SelenideElement profileMenuItem = $x("//button[@routerlink='/profile']");
    private final SelenideElement addJobButton = $x("//span[text()=' Create job ']/parent::button");

    private final SelenideElement viewInfoButton = $x("//mat-icon[@class ='mat-icon notranslate material-icons mat-icon-no-color']");


    public String getPageTitle() {
        return profileTitle.getText();
    }

    public String getUsername() {
        return username.getText();
    }

    public String getUserFullName() {
        return userFullName.getText();
    }

    public void clickOnProfileDropdownButton() {
        profileDropdownButton.click();
    }

    public ProfilePage clickOnProfileMenuItem() {
        profileMenuItem.click();
        return this;
    }

    public EditUserProfilePopup clickOnEditInfo() {
        editInfoButton.click();
        return new EditUserProfilePopup();
    }

    public WelcomePage closeProfile() {
        closeProfileButton.click();
        return new WelcomePage();
    }

    public boolean isJobDisplayedInMyJobs(String jobTitle) {
        List<SelenideElement> jobTitles = $$("div.mat-card-header-text>.mat-card-title");
        for (SelenideElement titleElement : jobTitles) {
            if (titleElement.getText().equals(jobTitle)) {
                return true;
            }
        }
        return false;
    }

    public ProfilePage clickOnAddJobButton() {
        addJobButton.$(".mat-button-wrapper").click();
        return this;
    }

    public JobDetailsPage clickViewInfoButton() {
        viewInfoButton.shouldBe(visible).shouldBe(Condition.enabled).click();
        return new JobDetailsPage();

    }

    }


package my.project.Pages;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.ElementsCollection;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;


public class ProfilePage {
    private final SelenideElement profileTitle = $("h1");
    private final SelenideElement username = $(".col h2");
    private final SelenideElement userFullName = $(".col h3");
    private final SelenideElement profileDropdownButton = $x("//button[@mattooltip='Profile']");
    private final SelenideElement editInfoButton = $x("//span[text()='Edit Info'] /parent::button");
    private final SelenideElement closeProfileButton = $x("//span[text()='Close profile'] /parent::button");
    private final SelenideElement profileMenuItem = $x("//button[@routerlink='/profile']");

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
}
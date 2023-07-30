package my.project.Pages;


import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import org.openqa.selenium.By;

public class EditUserProfilePopup {
    private final SelenideElement nameInput = $("input[formcontrolname='name']");
    private final SelenideElement lastnameInput = $("input[formcontrolname='lastname']");
    private final SelenideElement updateButton = $(By.xpath("//span[contains(@class, 'mat-button-wrapper')][contains(text(), 'Update')]"));
    private final SelenideElement closeButton = $(By.xpath("//span[contains(@class, 'mat-button-wrapper')][contains(text(), 'Close')]"));

    public EditUserProfilePopup setName(String name) {
        nameInput.setValue(name);
        return this;
    }

    public EditUserProfilePopup setLastname(String lastname) {
        lastnameInput.setValue(lastname);
        return this;
    }

    public ProfilePage clickOnUpdateButton() {
        updateButton.click();
        return new ProfilePage();
    }

    public ProfilePage clickOnCloseButton() {
        closeButton.click();
        return new ProfilePage();
    }
}
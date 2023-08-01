package my.project.Pages;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;


public class WelcomePage  {
    private final SelenideElement loginLocator = $("a[href='/login']");
    private final SelenideElement createAccountLocator = $("a[href='/register']");

    public WelcomePage() {
        open("https://freelance.lsrv.in.ua");
    }

    public LoginPage clickLogInButton() {
        loginLocator.click();
        return new LoginPage();
    }

    public RegistrationPage clickCreateAccountButton() {
        createAccountLocator.click();
        return new RegistrationPage();
    }

    public JobDetailsPage clickOnJobListing(int index) {
        // Знайдіть список оголошень і виберіть оголошення за індексом
        ElementsCollection jobListings = $$(".job-listing");
        if (jobListings.size() >= index) {
            // Клікніть на оголошення за індексом
            jobListings.get(index - 1).click();
            // Поверніть сторінку деталей оголошення
            return new JobDetailsPage();
        } else {
            throw new IndexOutOfBoundsException("Job listing not found with index: " + index);
        }
    }
}





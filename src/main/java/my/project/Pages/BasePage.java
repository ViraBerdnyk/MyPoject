package my.project.Pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class BasePage {


    protected WebDriverWait webDriverWait;

    public BasePage() {
        webDriverWait = new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofSeconds(10));
    }

    protected void clickButton(SelenideElement button) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(button)).click();
    }
}





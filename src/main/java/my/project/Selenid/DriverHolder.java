package my.project.Selenid;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;

public class DriverHolder {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driverInstance) {
        driver = driverInstance;
    }

    public static File getScreenShot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    }
}

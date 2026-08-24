package listeners;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ScreenshotUtils;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println(
                ">>> Test failure listener triggered for: "
                        + result.getName()
        );

        WebDriver driver = DriverFactory.getDriver();

        if (driver != null) {

            System.out.println(">>> Driver available. Taking screenshot.");

            ScreenshotUtils.takeScreenshot(
                    driver,
                    result.getName()
            );

        } else {

            System.out.println(
                    ">>> No WebDriver available. Screenshot skipped."
            );
        }
    }
}
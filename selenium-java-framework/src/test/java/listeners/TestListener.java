package listeners;

import driver.DriverFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ScreenshotUtils;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println(">>> Test failure listener triggered for: "
                + result.getName());

        System.out.println(">>> Driver is: "
                + DriverFactory.getDriver());

        ScreenshotUtils.takeScreenshot(
                DriverFactory.getDriver(),
                result.getName()
        );
    }
}
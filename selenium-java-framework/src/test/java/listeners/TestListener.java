package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.ExtentReportManager;
import utils.ScreenshotUtils;

public class TestListener implements ITestListener {

    private ExtentReports extentReports =
            ExtentReportManager.getInstance();

    private ExtentTest extentTest;

    @Override
    public void onTestStart(ITestResult result) {

        extentTest =
                extentReports.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        extentTest.pass("Test passed successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        extentTest.fail(result.getThrowable());

        System.out.println(
                ">>> Test failure listener triggered for: "
                        + result.getName()
        );

        WebDriver driver = DriverFactory.getDriver();

        if (driver != null) {

            System.out.println(
                    ">>> Driver available. Taking screenshot."
            );

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

    @Override
    public void onFinish(ITestContext context) {

        extentReports.flush();
    }
}
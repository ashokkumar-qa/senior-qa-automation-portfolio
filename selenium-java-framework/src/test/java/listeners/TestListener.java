package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import driver.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.ExtentReportManager;
import utils.ScreenshotUtils;

public class TestListener implements ITestListener {

    private static final Logger logger =
            LogManager.getLogger(TestListener.class);

    private final ExtentReports extentReports =
            ExtentReportManager.getInstance();

    private final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {

        logger.info("Test started: {}", result.getName());

        extentTest.set(
                extentReports.createTest(result.getName())
        );
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        logger.info("Test passed: {}", result.getName());

        extentTest.get().pass("Test passed successfully");
        extentTest.remove();
    }

    @Override
    public void onTestFailure(ITestResult result) {

        logger.error(
                "Test failed: {}",
                result.getName(),
                result.getThrowable()
        );

        extentTest.get().fail(result.getThrowable());

        WebDriver driver = DriverFactory.getDriver();

        if (driver != null) {

            logger.info(
                    "WebDriver available. Taking screenshot for failed test: {}",
                    result.getName()
            );

            ScreenshotUtils.takeScreenshot(
                    driver,
                    result.getName()
            );

        } else {

            logger.warn(
                    "No WebDriver available. Screenshot skipped for test: {}",
                    result.getName()
            );
        }
        extentTest.remove();
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        logger.warn("Test skipped: {}", result.getName());

        if (extentTest.get() != null) {
            extentTest.get().skip("Test skipped");
        }
        extentTest.remove();
    }



    @Override
    public void onFinish(ITestContext context) {

        logger.info(
                "Test execution finished. Generating Extent Report."
        );

        extentReports.flush();
    }
}
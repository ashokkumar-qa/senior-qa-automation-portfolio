package driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static final Logger logger =
            LogManager.getLogger(DriverFactory.class);

    private static final ThreadLocal<WebDriver> driver =
            new ThreadLocal<>();

    public static void initDriver(String browser) {

        logger.info("Initializing browser: {}", browser);

        WebDriver webDriver = switch (browser.toLowerCase()) {

            case "chrome" -> {

                ChromeOptions options = new ChromeOptions();

                if (System.getenv("CI") != null) {

                    logger.info(
                            "CI environment detected. Running Chrome in headless mode"
                    );

                    options.addArguments(
                            "--headless=new",
                            "--no-sandbox",
                            "--disable-dev-shm-usage",
                            "--window-size=1920,1080"
                    );
                }

                yield new ChromeDriver(options);
            }

            case "firefox" -> new FirefoxDriver();

            case "edge" -> new EdgeDriver();

            default -> throw new IllegalArgumentException(
                    "Unsupported browser: " + browser
            );
        };

        driver.set(webDriver);

        logger.info(
                "{} browser initialized successfully",
                browser
        );
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {

        if (driver.get() != null) {

            logger.info("Closing browser");

            try {
                driver.get().quit();
            } finally {
                driver.remove();
            }
            logger.info("Browser closed successfully");
        }
    }
}
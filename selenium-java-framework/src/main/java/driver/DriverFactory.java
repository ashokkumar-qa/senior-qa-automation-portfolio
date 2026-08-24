package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    //    Initializes and stores a WebDriver instance for the current thread
    public static void initDriver(String browser) {

        WebDriver webDriver = switch (browser.toLowerCase()) {
            case "chrome" -> {
                ChromeOptions options = new ChromeOptions();

                if (System.getenv("CI") != null) {
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
            default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
        };
        driver.set(webDriver);
    }

    //    Returns the WebDriver instance associated with the current thread
    public static WebDriver getDriver() {
        return driver.get();
    }

    //    Terminates the WebDriver session and removes it from the current thread
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}

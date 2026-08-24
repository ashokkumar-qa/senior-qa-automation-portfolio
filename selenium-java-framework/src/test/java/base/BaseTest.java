package base;

import driver.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    // Initializes a separate WebDriver instance before each test method
    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {
        DriverFactory.initDriver(browser);
        DriverFactory.getDriver().manage().window().maximize();

    }

    // Terminates the WebDriver session after each test method
    @AfterMethod
    public void tearDown(){
        DriverFactory.quitDriver();
    }

}

package tests;

import base.BaseTest;
import driver.DriverFactory;
import org.testng.annotations.Test;

public class SmokeTest extends BaseTest {

    @Test
    public void verifyGoogleLaunch() {
        DriverFactory.getDriver().get("http://www.google.com");
    }
}

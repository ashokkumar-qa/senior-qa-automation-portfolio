package tests;

import base.BaseTest;
import data.TestDataProvider;
import driver.DriverFactory;
import listeners.TestListener;
import model.InsuranceTestData;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import retry.RetryAnalyzer;
import workflow.InsuranceWorkFlow;

@Listeners(TestListener.class)
public class VehicleDataTest extends BaseTest {

    private HomePage homePage;
    private InsuranceWorkFlow insuranceWorkFlow;

    @Test(
            dataProvider = "vehicleData",
            dataProviderClass = TestDataProvider.class,
            retryAnalyzer = RetryAnalyzer.class)
    public void verifyVehicleDataSubmission(InsuranceTestData data) {

        DriverFactory.getDriver()
                .get("http://sampleapp.tricentis.com/");

        homePage = new HomePage(DriverFactory.getDriver());
        homePage.clickAutomobiles();

        insuranceWorkFlow = new InsuranceWorkFlow();

        insuranceWorkFlow.completeVehicleData(data);
        insuranceWorkFlow.completeInsurantData(data);
        insuranceWorkFlow.completeProductData(data);
        insuranceWorkFlow.completePriceOptionData(data);

        boolean result =
                insuranceWorkFlow.completeSendQuoteData(data);

        Assert.assertTrue(
                result,
                "Email success message was not displayed");
    }
}
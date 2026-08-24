package tests;

import base.BaseTest;
import data.TestDataProvider;
import driver.DriverFactory;
import model.InsuranceTestData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import retry.RetryAnalyzer;
import workflow.InsuranceWorkFlow;

public class VehicleDataTest extends BaseTest {

    private HomePage homePage;
    private InsuranceWorkFlow insuranceWorkFlow;

    @Test (
            dataProvider = "vehicleData",
            dataProviderClass = TestDataProvider.class,
            retryAnalyzer = RetryAnalyzer.class)
    public void verifyVehicleDataSubmission(InsuranceTestData data) {

        DriverFactory.getDriver().get("http://sampleapp.tricentis.com/");

        homePage = new HomePage(DriverFactory.getDriver());
        homePage.clickAutomobiles();

        insuranceWorkFlow = new InsuranceWorkFlow();
        insuranceWorkFlow.completeVehicleData(data);
        insuranceWorkFlow.completeInsurantData(data);
        insuranceWorkFlow.completeProductData(data);
        insuranceWorkFlow.completePriceOptionData(data);

        boolean result = insuranceWorkFlow.completeSendQuoteData(data);
        System.out.println(
                "Email success message is Displayed: " + result);
        Assert.assertTrue(
                result,
                "Email success message was not displayed");
    }
}

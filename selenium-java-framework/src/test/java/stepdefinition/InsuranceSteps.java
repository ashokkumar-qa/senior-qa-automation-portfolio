package stepdefinition;

import data.TestDataProvider;
import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import model.InsuranceTestData;
import org.testng.Assert;
import workflow.InsuranceWorkFlow;
import pages.HomePage;

public class InsuranceSteps {

    private InsuranceWorkFlow insuranceWorkFlow;
    private InsuranceTestData data;
    private boolean quoteSubmittedSuccessfully;

    @Given("the user is on the automobile insurance page")
    public void the_user_is_on_the_automobile_insurance_page() {

        DriverFactory.initDriver("chrome");

        insuranceWorkFlow = new InsuranceWorkFlow();

        DriverFactory.getDriver().get("http://sampleapp.tricentis.com/");

        HomePage homePage =
                new HomePage(DriverFactory.getDriver());

        homePage.clickAutomobiles();

        data = TestDataProvider.getInsuranceTestData(0);
    }

    @When("the user enters valid vehicle details")
    public void the_user_enters_valid_vehicle_details() {

        insuranceWorkFlow.completeVehicleData(data);

    }

    @When("the user enters valid insurant details")
    public void the_user_enters_valid_insurant_details() {
         insuranceWorkFlow.completeInsurantData(data);
    }

    @When("the user enters valid product details")
    public void the_user_enters_valid_product_details() {

        insuranceWorkFlow.completeProductData(data);

    }

    @When("the user selects a price option")
    public void the_user_selects_a_price_option() {

        insuranceWorkFlow.completePriceOptionData(data);

    }

    @When("the user submits the quote")
    public void the_user_submits_the_quote() {

        quoteSubmittedSuccessfully =
                insuranceWorkFlow.completeSendQuoteData(data);
    }

    @Then("the quote should be submitted successfully")
    public void the_quote_should_be_submitted_successfully() {

        Assert.assertTrue(
                quoteSubmittedSuccessfully,
                "Insurance quote was not submitted successfully"
        );
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}

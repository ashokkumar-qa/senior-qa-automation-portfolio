package workflow;

import driver.DriverFactory;
import model.InsuranceTestData;
import org.testng.Assert;
import pages.*;

public class InsuranceWorkFlow {

    public void completeVehicleData(InsuranceTestData data) {

        VehicleDataPage vehicleDataPage =
                new VehicleDataPage(DriverFactory.getDriver());

        vehicleDataPage.selectMake(data.getMake());
        vehicleDataPage.enterEnginePerformance(data.getEnginePerformance());
        vehicleDataPage.enterDateOfManufacture(data.getDateOfManufacture());
        vehicleDataPage.selectNumberOfSeats(Integer.parseInt(data.getNumberOfSeats()));
        vehicleDataPage.selectFuelType(data.getFuelType());
        vehicleDataPage.enterListPrice(data.getListPrice());
        vehicleDataPage.enterLicensePlateNumber(data.getLicensePlateNumber());
        vehicleDataPage.enterAnnualMileage(data.getAnnualMileage());
        vehicleDataPage.clickNext();
    }

    public void completeInsurantData(InsuranceTestData data) {

        InsurantDataPage insurantDataPage =
                new InsurantDataPage(DriverFactory.getDriver());

        insurantDataPage.enterFirstName(data.getFirstName());
        insurantDataPage.enterLastName(data.getLastName());
        insurantDataPage.enterBirthDate(data.getBirthDate());
        insurantDataPage.selectGenderMale(data.getGender());
        insurantDataPage.enterStreetAddress(data.getStreetAddress());
        insurantDataPage.selectCountry(data.getCountry());
        insurantDataPage.enterZipCode(data.getZipCode());
        insurantDataPage.enterCity(data.getCity());
        insurantDataPage.selectOccupation(data.getOccupation());
        insurantDataPage.selectHobbiesSpeeding(data.getHobby());
        insurantDataPage.clickNext();
    }

    public void completeProductData(InsuranceTestData data) {
        EnterProductData enterProductData =
                new EnterProductData(DriverFactory.getDriver());

        enterProductData.enterStartDate(data.getStartDate());
        enterProductData.selectInsuranceSum(data.getInsuranceSum());
        enterProductData.selectMeritRating(data.getMeritRating());
        enterProductData.selectDamageInsurance(data.getDamageInsurance());
        enterProductData.selectEuroProtection(data.getOptionalProducts());
        enterProductData.selectCourtesyCar(data.getCourtesyCar());
        enterProductData.clickNext();

    }

    public void completePriceOptionData(InsuranceTestData data) {

        SelectPriceOption selectPriceOption =
                new SelectPriceOption(DriverFactory.getDriver());

        selectPriceOption.selectPriceOption(data.getPriceOption());
        selectPriceOption.clickNext();
    }

    public boolean completeSendQuoteData(InsuranceTestData data) {

        SendQuote sendQuote = new SendQuote(DriverFactory.getDriver());
        sendQuote.enterEmail(data.getEmail());
        sendQuote.enterUserName(data.getUserName());
        sendQuote.enterPassword(data.getPassword());
        sendQuote.enterConfirmPassword(data.getConfirmPassword());
        sendQuote.clickSend();

        return sendQuote.isEmailSuccessMessageDisplayed();


    }
}
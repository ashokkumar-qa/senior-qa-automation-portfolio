package data;

import model.InsuranceTestData;
import org.testng.annotations.DataProvider;
import utils.ExcelUtils;

public class TestDataProvider {

    @DataProvider(name = "vehicleData")
    public Object[][] getVehicleData() {
        String filePath = "src/test/resources/Data.xlsx";

        Object[][] vehicleData =
                ExcelUtils.getExcelData(filePath, "VehicleData");

        Object[][] insurantData =
                ExcelUtils.getExcelData(filePath, "InsurantData");

        Object[][] productData =
                ExcelUtils.getExcelData(filePath, "ProductData");

        Object[][] priceOptionData =
                ExcelUtils.getExcelData(filePath, "PriceOption");

        Object[][] sendQuoteData =
                ExcelUtils.getExcelData(filePath, "SendQuote");


        Object[][] testData = new Object[vehicleData.length][1];

        for (int i = 0; i < vehicleData.length; i++) {
            InsuranceTestData data = new InsuranceTestData();
            data.setMake(vehicleData[i][0].toString());
            data.setEnginePerformance(vehicleData[i][1].toString());
            data.setDateOfManufacture(vehicleData[i][2].toString());
            data.setNumberOfSeats(vehicleData[i][3].toString());
            data.setFuelType(vehicleData[i][4].toString());
            data.setListPrice(vehicleData[i][5].toString());
            data.setLicensePlateNumber(vehicleData[i][6].toString());
            data.setAnnualMileage(vehicleData[i][7].toString());

            data.setFirstName(insurantData[i][0].toString());
            data.setLastName(insurantData[i][1].toString());
            data.setBirthDate(insurantData[i][2].toString());
            data.setGender(insurantData[i][3].toString());
            data.setStreetAddress(insurantData[i][4].toString());
            data.setCountry(insurantData[i][5].toString());
            data.setZipCode(insurantData[i][6].toString());
            data.setCity(insurantData[i][7].toString());
            data.setOccupation(insurantData[i][8].toString());
            data.setHobby(insurantData[i][9].toString());

            data.setStartDate(productData[i][0].toString());
            data.setInsuranceSum(productData[i][1].toString());
            data.setMeritRating(productData[i][2].toString());
            data.setDamageInsurance(productData[i][3].toString());
            data.setOptionalProducts(productData[i][4].toString());
            data.setCourtesyCar(productData[i][5].toString());

            data.setPriceOption(priceOptionData[i][0].toString());

            data.setEmail(sendQuoteData[i][0].toString());
            data.setUserName(sendQuoteData[i][1].toString());
            data.setPassword(sendQuoteData[i][2].toString());
            data.setConfirmPassword(sendQuoteData[i][3].toString());

            testData[i][0] = data;

        }

        return testData;
    }

    public static InsuranceTestData getInsuranceTestData(int rowIndex) {

        TestDataProvider testDataProvider = new TestDataProvider();

        Object[][] testData = testDataProvider.getVehicleData();

        return (InsuranceTestData)  testData[rowIndex][0];
    }
}
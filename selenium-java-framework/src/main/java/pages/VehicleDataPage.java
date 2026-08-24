package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementUtils;

public class VehicleDataPage {

//    private WebDriver driver;
    private ElementUtils elementUtils;

    private By makeDropDown = By.id("make");
    private By enginePerformanceInput = By.id("engineperformance");
    private By dateOfManufactureInput = By.id("dateofmanufacture");
//    private By modelDropDown = By.id("model");
    private By numberOfSeatsDropDown = By.id("numberofseats");
//    private By motorcycleNumberOfSeatsDropDown = By.id("numberofseatsmotorcycle");
    private By fuelTypeDropDown = By.id("fuel");
//    private By rightHandDriveYesRadio = By.xpath("//input[@id='righthanddriveyes']/parent::label");
//    private By cylinderCapacityInput = By.id("cylindercapacity");
//    private By payloadInput = By.id("payload");
//    private By totalWeightInput = By.id("totalweight");
    private By listPriceInput = By.id("listprice");
    private By licensePlateNumberInput = By.id("licenseplatenumber");
    private By annualMileageInput = By.id("annualmileage");
    private By nextButton = By.id("nextenterinsurantdata");



    public VehicleDataPage(WebDriver driver) {
//        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);

    }

    public void selectMake(String make) {
        elementUtils.selectByVisibleText(makeDropDown, make);
    }

    public void enterEnginePerformance(String enginePerformance) {
        elementUtils.type(enginePerformanceInput, enginePerformance);
    }

    public void enterDateOfManufacture(String date) {
        elementUtils.type(dateOfManufactureInput, date);
    }

//    public void selectModel(String model) {
//        elementUtils.selectByVisibleText(modelDropDown, model);
//    }

    public void selectNumberOfSeats(int number) {
        elementUtils.selectByVisibleText(numberOfSeatsDropDown, String.valueOf(number));
    }

//    public void selectMotorcycleNumberOfSeats(int number) {
//        elementUtils.selectByVisibleText(motorcycleNumberOfSeatsDropDown, String.valueOf(number));
//    }

    public void selectFuelType(String fuelType) {
        elementUtils.selectByVisibleText(fuelTypeDropDown, fuelType);
    }

//    public void selectRightHandDriveYes() {
//        elementUtils.click(rightHandDriveYesRadio);
//    }
//
//    public void enterCylinderCapacity(String cylinderCapacity) {
//        elementUtils.type(cylinderCapacityInput, cylinderCapacity);
//    }

//    public void enterPayload(String payload) {
//        elementUtils.type(payloadInput, payload);
//    }
//
//    public void enterTotalWeight(String totalWeight) {
//        elementUtils.type(totalWeightInput, totalWeight);
//    }
    
    public void enterListPrice(String listPrice) {
        elementUtils.type(listPriceInput, listPrice);
    }
    public void enterLicensePlateNumber(String licensePlateNumber) {
        elementUtils.type(licensePlateNumberInput, licensePlateNumber);
    }

    public void enterAnnualMileage(String annualMileage) {
        elementUtils.type(annualMileageInput, annualMileage);
    }

    public void clickNext() {
        elementUtils.click(nextButton);
    }


}

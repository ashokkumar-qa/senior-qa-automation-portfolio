package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementUtils;

public class VehicleDataPage {

    private final ElementUtils elementUtils;

    private final By makeDropDown = By.id("make");
    private final By enginePerformanceInput = By.id("engineperformance");
    private final By dateOfManufactureInput = By.id("dateofmanufacture");
    private final By numberOfSeatsDropDown = By.id("numberofseats");
    private final By fuelTypeDropDown = By.id("fuel");
    private final By listPriceInput = By.id("listprice");
    private final By licensePlateNumberInput = By.id("licenseplatenumber");
    private final By annualMileageInput = By.id("annualmileage");
    private final By nextButton = By.id("nextenterinsurantdata");



    public VehicleDataPage(WebDriver driver) {
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

    public void selectNumberOfSeats(int number) {
        elementUtils.selectByVisibleText(numberOfSeatsDropDown, String.valueOf(number));
    }

    public void selectFuelType(String fuelType) {
        elementUtils.selectByVisibleText(fuelTypeDropDown, fuelType);
    }
    
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

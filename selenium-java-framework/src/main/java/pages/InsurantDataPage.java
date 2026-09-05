package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementUtils;

public class InsurantDataPage {

    private final ElementUtils elementUtils;

    private final By firstNameInput = By.id("firstname");
    private final By lastNameInput = By.id("lastname");
    private final By birthDateInput = By.id("birthdate");
    private final By genderMaleRadio =
            By.xpath("//input[@id='gendermale']/parent::label");
    private final By genderFemaleRadio =
            By.xpath("//input[@id='genderfemale']/parent::label");
    private final By streetAddressInput = By.id("streetaddress");
    private final By countryDropDown = By.id("country");
    private final By zipCodeInput = By.id("zipcode");
    private final By cityInput = By.id("city");
    private final By occupationDropDown = By.id("occupation");
    private final By hobbiesSpeedingCheckBox =
            By.xpath("//input[@id='speeding']/parent::label");
    private final By hobbiesBungeeJumpingCheckBox =
            By.xpath("//input[@id='bungeejumping']/parent::label");

    private final By hobbiesCliffDivingCheckBox =
            By.xpath("//input[@id='cliffdiving']/parent::label");

    private final By hobbiesSkydivingCheckBox =
            By.xpath("//input[@id='skydiving']/parent::label");

    private final By hobbiesOtherCheckBox =
            By.xpath("//input[@id='other']/parent::label");
    private final By nextButton = By.id("nextenterproductdata");

    public InsurantDataPage(WebDriver driver) {
        this.elementUtils = new ElementUtils(driver);
    }

    public void enterFirstName(String firstName) {
        elementUtils.type(firstNameInput, firstName);

    }

    public void enterLastName(String lastName) {
        elementUtils.type(lastNameInput, lastName);
    }

    public void enterBirthDate(String birthDate) {
        elementUtils.type(birthDateInput, birthDate);
    }

    public void selectGender(String gender){

        if(gender.equalsIgnoreCase("male")){
            elementUtils.click(genderMaleRadio);
        } else if(gender.equalsIgnoreCase("female")){
            elementUtils.click(genderFemaleRadio);
        }
    }

    public void enterStreetAddress(String streetAddress) {
        elementUtils.type(streetAddressInput, streetAddress);
    }

    public void selectCountry(String country) {
        elementUtils.selectByVisibleText(countryDropDown, country);
    }

    public void enterZipCode(String zipCode) {
        elementUtils.type(zipCodeInput, zipCode);
    }

    public void enterCity(String city) {
        elementUtils.type(cityInput, city);
    }

    public void selectOccupation(String occupation) {
        elementUtils.selectByVisibleText(occupationDropDown, occupation);
    }

    public void selectHobbies(String hobby) {
        if (hobby.equalsIgnoreCase("Speeding")) {
            elementUtils.click(hobbiesSpeedingCheckBox);
        } else if (hobby.equalsIgnoreCase("Bungee Jumping")) {
            elementUtils.click(hobbiesBungeeJumpingCheckBox);
        } else if (hobby.equalsIgnoreCase("Cliff Diving")) {
            elementUtils.click(hobbiesCliffDivingCheckBox);
        } else if (hobby.equalsIgnoreCase("Skydiving")) {
            elementUtils.click(hobbiesSkydivingCheckBox);
        } else if (hobby.equalsIgnoreCase("Other")) {
            elementUtils.click(hobbiesOtherCheckBox);
        }
    }

    public void clickNext() {
        elementUtils.click(nextButton);
    }

}
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementUtils;

public class InsurantDataPage {

    private ElementUtils elementUtils;

    private By firstNameInput = By.id("firstname");
    private By lastNameInput = By.id("lastname");
    private By birthDateInput = By.id("birthdate");
    private By genderMaleRadio =
            By.xpath("//input[@id='gendermale']/parent::label");
    private By genderFemaleRadio =
            By.xpath("//input[@id='genderfemale']/parent::label");
    private By streetAddressInput = By.id("streetaddress");
    private By countryDropDown = By.id("country");
    private By zipCodeInput = By.id("zipcode");
    private By cityInput = By.id("city");
    private By occupationDropDown = By.id("occupation");
    private By hobbiesSpeedingCheckBox =
            By.xpath("//input[@id='speeding']/parent::label");
    private By hobbiesBungeeJumpingCheckBox =
            By.xpath("//input[@id='bungeejumping']/parent::label");

    private By hobbiesCliffDivingCheckBox =
            By.xpath("//input[@id='cliffdiving']/parent::label");

    private By hobbiesSkydivingCheckBox =
            By.xpath("//input[@id='skydiving']/parent::label");

    private By hobbiesOtherCheckBox =
            By.xpath("//input[@id='other']/parent::label");
    private By nextButton = By.id("nextenterproductdata");

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

    public void selectGenderMale(String gender){

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

    public void selectHobbiesSpeeding(String hobby) {
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
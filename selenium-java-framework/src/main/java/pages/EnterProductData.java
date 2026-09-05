package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementUtils;

public class EnterProductData {

    private final ElementUtils elementUtils;

    private final By startDateInput = By.id("startdate");
    private final By insuranceSumDropDown = By.id("insurancesum");
    private final By meritRatingDropDown = By.id("meritrating");
    private final By damageInsuranceDropDown = By.id("damageinsurance");
    private final By euroProtectionCheckBox=
            By.xpath("//input[@id='EuroProtection']/parent::label");
    private final By euroLegalDefenseInsuranceCheckBox=
            By.xpath("//input[@id='LegalDefenseInsurance']/parent::label");
    private final By courtesyCarDropDown = By.id("courtesycar");
    private final By nextButton = By.id("nextselectpriceoption");

    public EnterProductData(WebDriver driver) {
        this.elementUtils = new ElementUtils(driver);
    }

    public void enterStartDate(String startDate){
        elementUtils.type(startDateInput, startDate);
    }

    public void selectInsuranceSum(String insuranceSum){
        elementUtils.selectByVisibleText(insuranceSumDropDown, insuranceSum);
    }

    public void selectMeritRating(String meritRating){
        elementUtils.selectByVisibleText(meritRatingDropDown, meritRating);
    }

    public void selectDamageInsurance(String damageInsurance){
        elementUtils.selectByVisibleText(damageInsuranceDropDown, damageInsurance);
    }

    public void selectOptionalProtection(String optionalProducts){
        if(optionalProducts.equalsIgnoreCase("Euro Protection")){
            elementUtils.click(euroProtectionCheckBox);
        } else if (optionalProducts.equalsIgnoreCase("Legal Defense Insurance")) {
            elementUtils.click(euroLegalDefenseInsuranceCheckBox);
        }
    }

    public void selectCourtesyCar(String courtesyCar){
        elementUtils.selectByVisibleText(courtesyCarDropDown, courtesyCar);
    }

    public void clickNext(){
        elementUtils.click(nextButton);
    }
}

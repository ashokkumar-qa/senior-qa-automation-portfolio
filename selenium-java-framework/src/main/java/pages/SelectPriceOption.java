package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementUtils;

public class SelectPriceOption {

    private final ElementUtils elementUtils;

    private final By chooseSilverPriceOptionRadio =
            By.xpath("//input[@id='selectsilver']/parent::label");

    private final By chooseGoldPriceOptionRadio =
            By.xpath("//input[@id='selectgold']/parent::label");

    private final By choosePlatinumPriceOptionRadio =
            By.xpath("//input[@id='selectplatinum']/parent::label");

    private final By chooseUltimatePriceOptionRadio =
            By.xpath("//input[@id='selectultimate']/parent::label");


    private final By nextButton = By.id("nextsendquote");

    public SelectPriceOption(WebDriver driver) {
        this.elementUtils = new ElementUtils(driver);

    }

    public void selectPriceOption(String priceOption) {
        if (priceOption.equalsIgnoreCase("Silver")) {
            elementUtils.click(chooseSilverPriceOptionRadio);
        } else if (priceOption.equalsIgnoreCase("Gold")) {
            elementUtils.click(chooseGoldPriceOptionRadio);
        } else if (priceOption.equalsIgnoreCase("Platinum")) {
            elementUtils.click(choosePlatinumPriceOptionRadio);
        }  else if (priceOption.equalsIgnoreCase("Ultimate")) {
            elementUtils.click(chooseUltimatePriceOptionRadio);
        }

    }

    public void clickNext() {
        elementUtils.scrollToElement(nextButton);
        elementUtils.click(nextButton);
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementUtils;

public class SelectPriceOption {

    private ElementUtils elementUtils;

    private By chooseSilverPriceOptionRadio =
            By.xpath("//input[@id='selectsilver']/parent::label");

    private By chooseGoldPriceOptionRadio =
            By.xpath("//input[@id='selectgold']/parent::label");

    private By choosePlatinumPriceOptionRadio =
            By.xpath("//input[@id='selectplatinum']/parent::label");

    private By chooseuUltimatePriceOptionRadio =
            By.xpath("//input[@id='selectultimate']/parent::label");


    private By nextButton = By.id("nextsendquote");

    public SelectPriceOption(WebDriver driver) {
        this.elementUtils = new ElementUtils(driver);

    }

    public void selectPriceOption(String priceOption) {
        if (priceOption.equalsIgnoreCase("Silver")) {
            elementUtils.waitForClickability(chooseSilverPriceOptionRadio, 10);
            elementUtils.click(chooseSilverPriceOptionRadio);
        } else if (priceOption.equalsIgnoreCase("Gold")) {
            elementUtils.waitForClickability(chooseGoldPriceOptionRadio, 10);
            elementUtils.click(chooseGoldPriceOptionRadio);
        } else if (priceOption.equalsIgnoreCase("Platinum")) {
            elementUtils.waitForClickability(choosePlatinumPriceOptionRadio, 10);
            elementUtils.click(choosePlatinumPriceOptionRadio);
        }  else if (priceOption.equalsIgnoreCase("Ultimate")) {
            elementUtils.waitForClickability(chooseuUltimatePriceOptionRadio, 10);
            elementUtils.click(chooseuUltimatePriceOptionRadio);
        }

    }

    public void clickNext() {
        elementUtils.scrollToElement(nextButton);
        elementUtils.waitForClickability(nextButton, 10);
        elementUtils.click(nextButton);
    }
}

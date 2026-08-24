package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementUtils;

public class HomePage {

    private ElementUtils elementUtils;

    private By automobilesLink = By.id("nav_automobile");

    public HomePage(WebDriver driver) {
        this.elementUtils = new ElementUtils(driver);
    }

    public void clickAutomobiles(){
        elementUtils.waitForClickability(automobilesLink, 10);
        elementUtils.click(automobilesLink);
    }

}

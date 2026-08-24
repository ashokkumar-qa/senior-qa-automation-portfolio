package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class    ElementUtils {

    private WebDriver driver;

    public ElementUtils(WebDriver driver) {
        this.driver = driver;
    }
    public void selectByVisibleText(By locator, String text){
        Select select=new Select(driver.findElement(locator));
        select.selectByVisibleText(text);
    }

    public void type(By locator, String text){
      driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public boolean isDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

    public void waitForVisibility(By locator, int seconds){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForClickability(By locator, int seconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void scrollToElement(By locator){
        WebElement element = driver.findElement(locator);

        JavascriptExecutor js =  (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block:'center'});",
                element);
    }

}

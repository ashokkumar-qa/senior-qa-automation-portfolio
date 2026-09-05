package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementUtils;

public class SendQuote {

    private static final Logger logger =
            LogManager.getLogger(SendQuote.class);

    private final ElementUtils elementUtils;

    private final By emailInput = By.id("email");
    private final By userNameInput = By.id("username");
    private final By passwordInput = By.id("password");
    private final By confirmPasswordInput = By.id("confirmpassword");
    private final By sendButton = By.id("sendemail");
    private final By successMessage =
            By.xpath("//h2[text()='Sending e-mail success!']");

    public SendQuote(WebDriver driver) {
        this.elementUtils = new ElementUtils(driver);
    }

    public void enterEmail(String email) {
        elementUtils.type(emailInput, email);
    }

    public void enterUserName(String userName) {
        elementUtils.type(userNameInput, userName);
    }

    public void enterPassword(String password) {
        elementUtils.type(passwordInput, password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        elementUtils.type(confirmPasswordInput, confirmPassword);
    }

    public void clickSend() {

        elementUtils.click(sendButton);

        logger.info("Insurance quote send button clicked");
    }

    public boolean isEmailSuccessMessageDisplayed() {
        try {
            elementUtils.waitForVisibility(successMessage, 20);
            return elementUtils.isDisplayed(successMessage);
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }
}
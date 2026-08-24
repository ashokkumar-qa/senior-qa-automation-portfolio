package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementUtils;

public class SendQuote {

    private ElementUtils elementUtils;
    private By emailInput = By.id("email");
    private By userNameInput = By.id("username");
    private By passwordInput = By.id("password");
    private By confirmPasswordInput = By.id("confirmpassword");
    private By sendButton = By.id("sendemail");
    private By successMessage = By.xpath("//h2[text()='Sending e-mail success!']");



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

        System.out.println(">>> About to click SEND button");

        elementUtils.click(sendButton);

        System.out.println(">>> SEND button clicked");
    }

    public boolean isEmailSuccessMessageDisplayed() {
        elementUtils.waitForVisibility(successMessage, 20);
       return elementUtils.isDisplayed(successMessage);

    }
}

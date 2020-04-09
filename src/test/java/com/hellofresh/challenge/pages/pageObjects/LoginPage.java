package com.hellofresh.challenge.pages.pageObjects;

import com.hellofresh.challenge.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By createEmailInputId = By.id("email_create");
    private By createBtnId = By.id("SubmitCreate");
    private By emailInputId = By.id("email");
    private By passwordInputId = By.id("passwd");
    private By loginButtonId = By.id("SubmitLogin");

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        urlFragment = "authentication";
    }

    public void createAccountActionWithEmail(String email) {
        logger.info("Entering Email address.");
        getElementByVisibility(createEmailInputId).sendKeys(email);
        logger.info("Submitting email.");
        getElementByPresence(createBtnId).click();
    }

    public void loginAsExistingUser(String email, String password) {
        logger.info("Entering email as existing user.");
        getElementByVisibility(emailInputId).sendKeys(email);
        logger.info("Entering password as existing user.");
        getElement(passwordInputId).sendKeys(password);
        logger.info("Pressed Log In.");
        getElement(loginButtonId).click();
    }

    public String getRegisterButtonText(){
        return driver.findElement(createBtnId).getText();
    }
}

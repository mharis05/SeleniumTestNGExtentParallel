package com.hellofresh.challenge.pages.pageObjects;

import com.hellofresh.challenge.pages.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Login PageObject class
 */
public class LoginPage extends BasePage {

    private static Logger logger = Logger.getLogger(LoginPage.class.getName());

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

    /**
     * create account using provided email
     * @param email email address String
     */
    public void createAccountActionWithEmail(String email) {
        logger.info("Entering Email address.");
        getElementByVisibility(createEmailInputId).sendKeys(email);
        logger.info("Submitting email.");
        getElementByPresence(createBtnId).click();
    }

    /**
     * login as existing user provided credentials
     * @param email as string
     * @param password as string
     */
    public void loginAsExistingUser(String email, String password) {
        logger.info("Entering email as existing user.");
        getElementByVisibility(emailInputId).sendKeys(email);
        logger.info("Entering password as existing user.");
        getElement(passwordInputId).sendKeys(password);
        logger.info("Pressed Log In.");
        getElement(loginButtonId).click();
    }

    /**
     * Get button text
     * @return String text
     */
    public String getRegisterButtonText(){
        return driver.findElement(createBtnId).getText();
    }
}

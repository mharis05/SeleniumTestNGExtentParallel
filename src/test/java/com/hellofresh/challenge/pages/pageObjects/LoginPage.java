package com.hellofresh.challenge.pages.pageObjects;

import com.hellofresh.challenge.pages.BasePage;
import com.hellofresh.challenge.pages.locators.LoginPageLocators;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    WebDriver driver;
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        urlFragment = "authentication";
    }

    public void createAccountActionWithEmail(String email) {
        getElementByVisibility(LoginPageLocators.createEmailInputId).sendKeys(email);
        getElementByPresence(LoginPageLocators.createBtnId).click();
    }

    public String getRegisterButtonText(){
        return driver.findElement(LoginPageLocators.createBtnId).getText();
    }
}

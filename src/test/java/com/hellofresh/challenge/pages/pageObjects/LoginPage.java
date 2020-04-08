package com.hellofresh.challenge.pages.pageObjects;

import com.hellofresh.challenge.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    By createEmailInputId = By.id("email_create");
    By createBtnId = By.id("SubmitCreate");

    WebDriver driver;
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        urlFragment = "authentication";
    }

    public void createAccountActionWithEmail(String email) {
        getElementByVisibility(createEmailInputId).sendKeys(email);
        getElementByPresence(createBtnId).click();
    }

    public String getRegisterButtonText(){
        return driver.findElement(createBtnId).getText();
    }
}

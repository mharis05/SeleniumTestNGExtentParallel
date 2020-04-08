package com.hellofresh.challenge.pages.pageObjects;

import com.hellofresh.challenge.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage {

    public By btnLoginClassName = By.className("login");

//    WebDriver driver;
    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickLogin() {
        logger.info("Navigating to Log In Page.");
        getElementByVisibility(btnLoginClassName).click();
    }
}

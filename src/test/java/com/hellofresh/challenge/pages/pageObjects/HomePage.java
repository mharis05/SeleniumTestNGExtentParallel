package com.hellofresh.challenge.pages.pageObjects;

import com.hellofresh.challenge.pages.BasePage;
import com.hellofresh.challenge.pages.locators.HomePageLocators;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage {

//    WebDriver driver;
    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickLogin() {
        logger.info("Clicking on the login button.");
        getElementByVisibility(HomePageLocators.btnLoginClassName).click();
    }
}

package com.hellofresh.challenge.pages.pageObjects;

import com.hellofresh.challenge.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page object class for Home Page
 */
public class HomePage extends BasePage {

    private By btnLoginClassName = By.className("login");

    /**
     * Constructor
     * @param driver Webdriver Object
     */
    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Action for clicking on Sign In button
     */
    public void clickLogin() {
        logger.info("Navigating to Log In Page.");
        getElementByVisibility(btnLoginClassName).click();
    }
}

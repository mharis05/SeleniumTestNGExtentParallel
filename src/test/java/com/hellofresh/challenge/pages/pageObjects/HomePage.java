package com.hellofresh.challenge.pages.pageObjects;

import com.hellofresh.challenge.pages.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page object class for Home Page
 */
public class HomePage extends BasePage {
    private static final Logger logger = LogManager.getLogger(HomePage.class);

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

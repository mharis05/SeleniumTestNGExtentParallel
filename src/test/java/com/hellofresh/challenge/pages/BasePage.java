package com.hellofresh.challenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

/**
 * Base page containing common actions for Page Objects
 * I have not used PageFactory to help with clear assessment
 * with minimal framework usage.
 */
public class BasePage {
    protected WebDriverWait wait;
    protected WebDriver driver;
    protected final static Logger logger = Logger.getLogger(BasePage.class.getName());
    protected String urlFragment;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        // Common wait object used across all pages.
        // In ideal case wait should not be used in tests, only on Pages.
        wait = new WebDriverWait(driver, 10, 500);
    }

    /**
     * Get current URL.
     * @return String URL
     */
    public String getUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * Waits until an element becomes visible and return that element
     * @param locator
     * @return WebElement
     */
    protected WebElement getElementByVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Waits until an element is present and return that element
     * @param locator
     * @return WebElement
     */
    protected WebElement getElementByPresence(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * Wait for URL to update
     * @param url
     * @return Boolean result
     */
    public boolean waitForUrlToContain(String url) {
        return wait.until(ExpectedConditions.urlContains(url));
    }

    /**
     * Find an element.
     * @param locator
     * @return
     */
    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    /**
     * Get URLFragment class variable.
     * I use it for asserting controller name in URL for pages.
     * @return String urlFragment
     */
    public String getPageUrlFragment() {
        return urlFragment;
    }

    /**
     * Get test in innerHTML of an Element.
     * @param element WebElement
     * @return String text
     */
    public String getElementText(WebElement element) {
        return element.getText();
    }
}

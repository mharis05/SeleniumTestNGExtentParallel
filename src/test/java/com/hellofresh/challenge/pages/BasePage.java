package com.hellofresh.challenge.pages;

import com.hellofresh.challenge.pages.locators.CreateAccountLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

public class BasePage {
    protected WebDriverWait wait;
    protected WebDriver driver;
    protected final static Logger logger = Logger.getLogger(BasePage.class.getName());

    protected String urlFragment;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10, 500);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    protected WebElement getElementByVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement getElementByPresence(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public boolean waitForUrlToContain(String url) {
        return wait.until(ExpectedConditions.urlContains(url));
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public String getPageUrlFragment() {
        return urlFragment;
    }

    public String getElementText(WebElement element) {
        return element.getText();
    }
}

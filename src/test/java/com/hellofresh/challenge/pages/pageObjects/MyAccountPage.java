package com.hellofresh.challenge.pages.pageObjects;

import com.hellofresh.challenge.pages.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * My Account page object
 */
public class MyAccountPage extends BasePage {

    private static Logger logger = Logger.getLogger(MyAccountPage.class.getName());

    private By headingMyAccountCss = By.cssSelector("h1");
    private By accountName = By.className("account");
    private By accountInfo = By.className("info-account");
    private By btnLogout = By.className("logout");
    private By linkWomenText = By.linkText("Women");
    private By linkDressesText = By.linkText("Dresses");
    private By linkTshirtsText = By.linkText("Women");

    public MyAccountPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        urlFragment = "my-account";
        getElementByPresence(headingMyAccountCss);
    }

    /**
     * Selects product category based on provided string
     * @param category string
     */
    public void selectCategory(String category) {
        logger.info("Selecting category: "+ category);
        switch (category.toLowerCase()) {
            case "women":
                getElement(linkWomenText).click();
                break;
            case "dresses":
                getElement(linkDressesText).click();
                break;
            case "t-shirts":
                getElement(linkTshirtsText).click();
                break;
        }
    }

    public WebElement getHeadingMyAccountCss() {
        return getElementByVisibility(headingMyAccountCss);
    }

    public WebElement getAccountName() {
        return getElement(accountName);
    }

    public WebElement getBtnLogout() {
        return getElement(btnLogout);
    }

}

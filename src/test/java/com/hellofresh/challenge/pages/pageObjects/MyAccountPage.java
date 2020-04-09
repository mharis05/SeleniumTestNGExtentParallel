package com.hellofresh.challenge.pages.pageObjects;

import com.hellofresh.challenge.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage extends BasePage {

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

    public void selectCategory(String category) {

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

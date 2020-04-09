package com.hellofresh.challenge.pages.pageObjects;

import com.hellofresh.challenge.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePage {

    public By headingMyAccountCss = By.cssSelector("h1");
    public By accountNameClass = By.className("account");
    public By accountInfoClass = By.className("info-account");
    public By btnLogout = By.className("logout");
    public By linkWomenText = By.linkText("Women");
    public By linkDressesText = By.linkText("Dresses");
    public By linkTshirtsText = By.linkText("Women");

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


}

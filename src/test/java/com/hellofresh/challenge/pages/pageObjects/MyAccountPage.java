package com.hellofresh.challenge.pages.pageObjects;

import com.hellofresh.challenge.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePage {

    public By headingMyAccountCss = By.cssSelector("h1");
    public By accountNameClass = By.className("account");
    public By accountInfoClass = By.className("info-account");
    public By btnLogout = By.className("logout");

    public MyAccountPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        urlFragment = "my-account";
        getElementByPresence(headingMyAccountCss);
    }


}

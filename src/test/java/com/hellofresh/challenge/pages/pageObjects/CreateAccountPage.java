package com.hellofresh.challenge.pages.pageObjects;

import com.hellofresh.challenge.pages.BasePage;
import com.hellofresh.challenge.pages.locators.CreateAccountLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage extends BasePage {

    By genderMrsRadioId = By.id("id_gender2");
    By inputFirstNameId = By.id("customer_firstname");
    By inputLastNameId = By.id("customer_lastname");
    By inputEmailId = By.id("email");
    By inputPasswordId = By.id("passwd");
    By selectDobDays = By.id("days");
    By selectDobMonths = By.id("months");
    By selectDobYears = By.id("years");
    By inputCompanyId = By.id("company");
    By inputAddressId = By.id("address1");
    By inputAddress2Id = By.id("address2");
    By inputCityId = By.id("city");
    By selectStateId = By.id("id_state");
    By inputPostCodeId = By.id("postcode");
    By inputOtherId = By.id("other");
    By inputPhoneId = By.id("phone");
    By inputPhoneMobileId = By.id("phone_mobile");
    By inputAliasId = By.id("alias");
    By btnSubmitId = By.id("submitAccount");

    public CreateAccountPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        urlFragment = "account-creation";
        getElementByPresence(genderMrsRadioId);
    }

    public void enterAccountDetails() {
        getElement(inputFirstNameId).sendKeys("HARIS");
        getElement(inputLastNameId).sendKeys("SALEEM");
        getElement(inputPasswordId).sendKeys("Qwerty");
        Select select = new Select(getElement(selectDobDays));
        select.selectByValue("1");

        select = new Select(getElement(selectDobMonths));
        select.selectByValue("1");

        select = new Select(getElement(selectDobYears));
        select.selectByValue("2000");

        getElement(inputCompanyId).sendKeys("Company");
        getElement(inputAddressId).sendKeys("Qwerty, 123");
        getElement(inputAddress2Id).sendKeys("zxcvb");
        getElement(inputCityId).sendKeys("Qwerty");

        select = new Select(getElement(selectStateId));
        select.selectByVisibleText("Colorado");

        getElement(inputPostCodeId).sendKeys("12345");
        getElement(inputOtherId).sendKeys("Qwerty");
        getElement(inputPhoneId).sendKeys("12345123123");
        getElement(inputPhoneMobileId).sendKeys("12345123123");
        getElement(inputAliasId).sendKeys("hf");
        getElement(btnSubmitId).click();
    }

    public String getStoredEmailText() {
        return getElement(CreateAccountLocators.inputEmailId)
                .getAttribute("value");
    }


}

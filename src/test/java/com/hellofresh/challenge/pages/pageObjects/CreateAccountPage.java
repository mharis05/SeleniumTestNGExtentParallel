package com.hellofresh.challenge.pages.pageObjects;

import com.hellofresh.challenge.pages.BasePage;
import com.hellofresh.challenge.utils.UserAccount;
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

    public void enterAccountDetails(UserAccount userAccount) {
        logger.info("Entering User Details.");
        getElement(inputFirstNameId).sendKeys(userAccount.getFirstName());
        getElement(inputLastNameId).sendKeys(userAccount.getLastName());
        getElement(inputPasswordId).sendKeys(userAccount.getPassword());


        logger.info("Selecting Date of Birth.");
        Select select = new Select(getElement(selectDobDays));
        select.selectByValue(userAccount.getBirthday().toString());

        select = new Select(getElement(selectDobMonths));
        select.selectByValue(userAccount.getBirthMonth().toString());

        select = new Select(getElement(selectDobYears));
        select.selectByValue(userAccount.getBirthYear().toString());

        logger.info("Entering Address and Location details.");
        getElement(inputCompanyId).sendKeys(userAccount.getCompany());
        getElement(inputAddressId).sendKeys(userAccount.getAddress1());
        getElement(inputAddress2Id).sendKeys(userAccount.getAddress2());
        getElement(inputCityId).sendKeys(userAccount.getCity());

        logger.info("Selecting State.");
        select = new Select(getElement(selectStateId));
        select.selectByVisibleText(userAccount.getState());

        logger.info("Entering other details.");
        getElement(inputPostCodeId).sendKeys(userAccount.getPostcode());
        getElement(inputOtherId).sendKeys(userAccount.getOther());
        getElement(inputPhoneId).sendKeys(userAccount.getPhone());
        getElement(inputPhoneMobileId).sendKeys(userAccount.getMobilePhone());
        getElement(inputAliasId).sendKeys(userAccount.getAlias());
        getElement(btnSubmitId).click();
    }

    public String getStoredEmailText() {
        return getElement(inputEmailId).getAttribute("value");
    }


}

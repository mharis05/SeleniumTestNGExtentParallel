package com.hellofresh.challenge.pages.pageObjects;

import com.hellofresh.challenge.pages.BasePage;
import com.hellofresh.challenge.utils.UserAccount;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Create Account Page
 */
public class CreateAccountPage extends BasePage {

    private static Logger logger = Logger.getLogger(CreateAccountPage.class.getName());

    private By genderMrsRadioId = By.id("id_gender2");
    private By inputFirstNameId = By.id("customer_firstname");
    private By inputLastNameId = By.id("customer_lastname");
    private By inputEmailId = By.id("email");
    private By inputPasswordId = By.id("passwd");
    private By selectDobDays = By.id("days");
    private By selectDobMonths = By.id("months");
    private By selectDobYears = By.id("years");
    private By inputCompanyId = By.id("company");
    private By inputAddressId = By.id("address1");
    private By inputAddress2Id = By.id("address2");
    private By inputCityId = By.id("city");
    private By selectStateId = By.id("id_state");
    private By inputPostCodeId = By.id("postcode");
    private By inputOtherId = By.id("other");
    private By inputPhoneId = By.id("phone");
    private By inputPhoneMobileId = By.id("phone_mobile");
    private By inputAliasId = By.id("alias");
    private By btnSubmitId = By.id("submitAccount");

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
        logger.info("Setting birth Day to " + userAccount.getBirthday().toString());
        Select select = new Select(getElement(selectDobDays));
        select.selectByValue(userAccount.getBirthday().toString());

        select = new Select(getElement(selectDobMonths));
        logger.info("Setting birth Month to " + userAccount.getBirthMonth().toString());
        select.selectByValue(userAccount.getBirthMonth().toString());

        select = new Select(getElement(selectDobYears));
        logger.info("Setting birth Year to " + userAccount.getBirthYear().toString());
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

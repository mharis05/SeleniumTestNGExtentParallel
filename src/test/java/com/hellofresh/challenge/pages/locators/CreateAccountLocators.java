package com.hellofresh.challenge.pages.locators;

import org.openqa.selenium.By;

public interface CreateAccountLocators {
    By genderMrsRadioId = By.id("id_gender2");
    By inputFirstNameId = By.id("customer_firstname");
    By inputLastNameId = By.id("customer_lastname");
    By inputEmailId = By.id("email");
    By inputPasswordId = By.id("passwd");
    By dobDaysSelect = By.id("days");
    By dobMonthsSelect = By.id("months");
    By dobYearsSelect = By.id("years");
    By inputCompanyId = By.id("company");
    By inputAddressId = By.id("address1");
    By inputAddress2Id = By.id("address2");
    By inputCityId = By.id("city");
    By inputStateId = By.id("id_state");
    By inputPostCodeId = By.id("postcode");
    By inputOtherId = By.id("other");
    By inputPhoneId = By.id("phone");
    By inputPhoneMobileId = By.id("phone_mobile");
    By inputAliasId = By.id("alias");
    By btnSubmitId = By.id("submitAccount");

}

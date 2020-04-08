package com.hellofresh.challenge.tests;

import com.hellofresh.challenge.pages.BasePage;
import com.hellofresh.challenge.pages.locators.CreateAccountLocators;
import com.hellofresh.challenge.pages.pageObjects.CreateAccountPage;
import com.hellofresh.challenge.pages.pageObjects.HomePage;
import com.hellofresh.challenge.pages.pageObjects.LoginPage;
import com.hellofresh.challenge.pages.pageObjects.MyAccountPage;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import java.util.Date;

public class E2ETests extends BaseTest {

    @Test
    public void signInTest() {
        String timestamp = String.valueOf(new Date().getTime());
        String email = "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";
        softly = new SoftAssertions();

        HomePage homePage = new HomePage(getDriver());
        homePage.clickLogin();

        LoginPage loginPage = new LoginPage(getDriver());
        softly.assertThat(loginPage.getRegisterButtonText()).isEqualTo("Create an account");
        softly.assertThat(loginPage.getUrl()).contains(loginPage.getPageUrlFragment());
        loginPage.createAccountActionWithEmail(email);

        CreateAccountPage createAccountPage = new CreateAccountPage(getDriver());
        softly.assertThat(createAccountPage.
                waitForUrlToContain(createAccountPage.getPageUrlFragment())).isTrue();
        softly.assertThat(createAccountPage.getStoredEmailText())
                .isEqualTo(email);

        createAccountPage.enterAccountDetails();

        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        softly.assertThat(myAccountPage.getElement(myAccountPage.headingMyAccountCss).getText())
                .isEqualToIgnoringCase("MY ACCOUNT");
        softly.assertThat(myAccountPage.getElement(myAccountPage.accountNameClass).getText())
                .isEqualToIgnoringCase("Add later");

        softly.assertAll();
    }
}

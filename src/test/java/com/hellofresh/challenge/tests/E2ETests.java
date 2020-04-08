package com.hellofresh.challenge.tests;

import com.hellofresh.challenge.pages.pageObjects.CreateAccountPage;
import com.hellofresh.challenge.pages.pageObjects.HomePage;
import com.hellofresh.challenge.pages.pageObjects.LoginPage;
import com.hellofresh.challenge.pages.pageObjects.MyAccountPage;
import com.hellofresh.challenge.utils.TestDataProvider;
import com.hellofresh.challenge.utils.UserAccount;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Date;

public class E2ETests extends BaseTest {


    @Test(dataProvider = "account-data-provider", dataProviderClass = TestDataProvider.class)
    public void signInTest(UserAccount userAccount) {
        softly = new SoftAssertions();

        HomePage homePage = new HomePage(getDriver());
        homePage.clickLogin();

        LoginPage loginPage = new LoginPage(getDriver());
        softly.assertThat(loginPage.getRegisterButtonText()).isEqualTo("Create an account");
        softly.assertThat(loginPage.getUrl()).contains(loginPage.getPageUrlFragment());
        loginPage.createAccountActionWithEmail(userAccount.getEmail());

        CreateAccountPage createAccountPage = new CreateAccountPage(getDriver());
        softly.assertThat(createAccountPage.
                waitForUrlToContain(createAccountPage.getPageUrlFragment())).isTrue();
        softly.assertThat(createAccountPage.getStoredEmailText())
                .isEqualTo(userAccount.getEmail());


        createAccountPage.enterAccountDetails(userAccount);

        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        softly.assertThat(myAccountPage.getElement(myAccountPage.headingMyAccountCss).getText())
                .isEqualToIgnoringCase("MY ACCOUNT");
        softly.assertThat(myAccountPage.getElement(myAccountPage.accountNameClass).getText())
                .isEqualToIgnoringCase(userAccount.getFullName());

        softly.assertAll();
    }
}

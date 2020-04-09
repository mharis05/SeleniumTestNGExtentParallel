package com.hellofresh.challenge.tests;

import com.hellofresh.challenge.pages.pageObjects.CreateAccountPage;
import com.hellofresh.challenge.pages.pageObjects.HomePage;
import com.hellofresh.challenge.pages.pageObjects.LoginPage;
import com.hellofresh.challenge.pages.pageObjects.MyAccountPage;
import com.hellofresh.challenge.utils.TestDataProvider;
import com.hellofresh.challenge.utils.UserAccount;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class AuthenticationTests extends BaseTest {

    @Test(dataProvider = "account-data-provider",
            dataProviderClass = TestDataProvider.class,
            description = "Validate that a new User can register successfully.")
    public void signInTest(UserAccount userAccount) {
        SoftAssertions softly = new SoftAssertions();
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
        softly.assertThat(myAccountPage.getElement(myAccountPage.btnLogout).isDisplayed()).isTrue();

        softly.assertAll();
    }

    @Test(description = "Validate that an existing User can log in to their account successfully.")
    public void logInTest() {
        SoftAssertions softly = new SoftAssertions();
        String fullName = "Joe Black";
        String existingUserEmail = "hf_challenge_123456@hf123456.com";
        String existingUserPassword = "12345678";

        HomePage homePage = new HomePage(getDriver());
        homePage.clickLogin();
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.loginAsExistingUser(existingUserEmail, existingUserPassword);

        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        softly.assertThat(myAccountPage.getElement(myAccountPage.headingMyAccountCss).getText())
                .isEqualToIgnoringCase("MY ACCOUNT");
        softly.assertThat(myAccountPage.getElement(myAccountPage.accountNameClass).getText())
                .isEqualToIgnoringCase(fullName);
        softly.assertThat(myAccountPage.getElement(myAccountPage.btnLogout).isDisplayed()).isTrue();

        softly.assertAll();
    }
}

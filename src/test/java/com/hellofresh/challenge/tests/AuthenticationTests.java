package com.hellofresh.challenge.tests;

import com.hellofresh.challenge.pages.pageObjects.CreateAccountPage;
import com.hellofresh.challenge.pages.pageObjects.HomePage;
import com.hellofresh.challenge.pages.pageObjects.LoginPage;
import com.hellofresh.challenge.pages.pageObjects.MyAccountPage;
import com.hellofresh.challenge.utils.TestDataProvider;
import com.hellofresh.challenge.utils.UserAccount;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import java.util.HashMap;

/**
 * Test Class: Authentication Scenarios
 * Tests:
 * User Registration,
 * Log In as Existing User
 */
public class AuthenticationTests extends BaseTest {

    /**
     * Test: User Registration scenario
     * Receives data from data provider class
     * @param userAccount UserAccount POJO with dynamically generated fake data.
     */
    @Test(dataProvider = "account-data-provider",
            dataProviderClass = TestDataProvider.class,
            description = "Validate that a new User can register successfully.")
    public void userRegistrationTest(UserAccount userAccount) {
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
        softly.assertThat(myAccountPage.getHeadingMyAccountCss().getText())
                .isEqualToIgnoringCase("MY ACCOUNT");
        softly.assertThat(myAccountPage.getAccountName().getText())
                .isEqualToIgnoringCase(userAccount.getFullName());
        softly.assertThat(myAccountPage.getBtnLogout().isDisplayed()).isTrue();

        softly.assertAll();
    }

    /**
     * Test: Sign in scenario.
     * Receives data from data provider class
     * @param data with existing user credentials.
     */
    @Test(dataProvider = "existing-user-provider",
            dataProviderClass = TestDataProvider.class,
            description = "Validate that an existing User can log in to their account successfully.")
    public void logInTest(HashMap<String, String> data) {
        SoftAssertions softly = new SoftAssertions();
        String fullName = data.get("fullName");

        HomePage homePage = new HomePage(getDriver());
        homePage.clickLogin();
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.loginAsExistingUser(data.get("email"), data.get("password"));

        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        softly.assertThat(myAccountPage.getHeadingMyAccountCss().getText())
                .isEqualToIgnoringCase("MY ACCOUNT");
        softly.assertThat(myAccountPage.getAccountName().getText())
                .isEqualToIgnoringCase(fullName);
        softly.assertThat(myAccountPage.getBtnLogout().isDisplayed()).isTrue();

        softly.assertAll();
    }
}

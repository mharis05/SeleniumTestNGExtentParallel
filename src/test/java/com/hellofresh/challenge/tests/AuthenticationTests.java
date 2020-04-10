package com.hellofresh.challenge.tests;

import com.hellofresh.challenge.pages.pageObjects.CreateAccountPage;
import com.hellofresh.challenge.pages.pageObjects.HomePage;
import com.hellofresh.challenge.pages.pageObjects.LoginPage;
import com.hellofresh.challenge.pages.pageObjects.MyAccountPage;
import com.hellofresh.challenge.utils.TestDataProvider;
import com.hellofresh.challenge.utils.UserAccount;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import java.util.HashMap;

/**
 * Test Class: Authentication Scenarios
 * Tests:
 * User Registration,
 * Log In as Existing User
 */
public class AuthenticationTests extends BaseTest {

    private static Logger logger = Logger.getLogger(AuthenticationTests.class.getName());

    /**
     * Test: User Registration scenario
     * Receives data from data provider class
     *
     * @param userAccount UserAccount POJO with dynamically generated fake data.
     */
    @Test(dataProvider = "account-data-provider",
            dataProviderClass = TestDataProvider.class,
            description = "Validate that a new User can register successfully.")
    public void userRegistrationTest(UserAccount userAccount, HashMap<String, String> expectedTexts) {
        SoftAssertions softly = new SoftAssertions();

        HomePage homePage = new HomePage(getDriver());
        homePage.clickLogin();

        LoginPage loginPage = new LoginPage(getDriver());
        logger.info("Validating Register button text.");
        softly.assertThat(loginPage.getRegisterButtonText()).isEqualTo(expectedTexts.get("createAccountButtonText"));
        logger.info("Validating Register URL fragment for Login page.");
        softly.assertThat(loginPage.getUrl()).contains(loginPage.getPageUrlFragment());
        loginPage.createAccountActionWithEmail(userAccount.getEmail());

        CreateAccountPage createAccountPage = new CreateAccountPage(getDriver());
        logger.info("Validating Register URL fragment for Login page.");
        softly.assertThat(createAccountPage.
                waitForUrlToContain(createAccountPage.getPageUrlFragment())).isTrue();
        logger.info("Validating email address to match with provided email.");
        softly.assertThat(createAccountPage.getStoredEmailText())
                .isEqualTo(userAccount.getEmail());

        createAccountPage.enterAccountDetails(userAccount);

        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        logger.info("Validating account label.");
        softly.assertThat(myAccountPage.getHeadingMyAccountCss().getText())
                .isEqualTo(expectedTexts.get("myAccountLabelText"));
        logger.info("Validating Register URL fragment for Login page.");
        softly.assertThat(myAccountPage.getAccountName().getText())
                .isEqualToIgnoringCase(userAccount.getFullName());
        logger.info("Validating visibility of logout button.");
        softly.assertThat(myAccountPage.getBtnLogout().isDisplayed()).isTrue();

        softly.assertAll();
    }

    /**
     * Test: Sign in scenario.
     * Receives data from data provider class
     *
     * @param data with existing user credentials.
     */
    @Test(dataProvider = "existing-user-provider",
            dataProviderClass = TestDataProvider.class,
            description = "Validate that an existing User can log in to their account successfully.")
    public void logInTest(HashMap<String, String> data, HashMap<String, String> expectedTexts) {
        SoftAssertions softly = new SoftAssertions();

        String fullName = data.get("fullName");

        HomePage homePage = new HomePage(getDriver());
        homePage.clickLogin();
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.loginAsExistingUser(data.get("email"), data.get("password"));

        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        logger.info("Validating account label.");
        softly.assertThat(myAccountPage.getHeadingMyAccountCss().getText())
                .isEqualToIgnoringCase(expectedTexts.get("myAccountLabelText"));
        logger.info("Validating Register URL fragment for Login page.");
        softly.assertThat(myAccountPage.getAccountName().getText())
                .isEqualToIgnoringCase(fullName);
        logger.info("Validating visibility of logout button.");
        softly.assertThat(myAccountPage.getBtnLogout().isDisplayed()).isTrue();

        softly.assertAll();
    }
}

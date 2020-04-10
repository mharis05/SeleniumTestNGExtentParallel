package com.hellofresh.challenge.tests;

import com.hellofresh.challenge.pages.pageObjects.*;
import com.hellofresh.challenge.utils.TestDataProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class CheckoutTests extends BaseTest {

    private static final Logger logger = LogManager.getLogger(CheckoutTests.class);

    /**
     * Test: Checkout Scenario
     * Receives data from Data provider class as parameter
     * @param authData existing User Data as HashMap
     * @param product Product data to use in test as String
     * All assertions are executed in Tests and not in Pages.
     */
    @Test(dataProvider = "product-data-provider",
            dataProviderClass = TestDataProvider.class,
            description = "Validate that existing user can place an order successfully.")
    public void checkoutTest(Map<String, String> authData, String product, HashMap<String, String> expectedValues) {
        SoftAssertions softly = new SoftAssertions();

        HomePage homePage = new HomePage(getDriver());
        homePage.clickLogin();

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginAsExistingUser(authData.get("email"), authData.get("password"));

        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        myAccountPage.selectCategory("Women");

        CategoryItemsPage categoryItemsPage = new CategoryItemsPage(getDriver());
        categoryItemsPage.selectProduct(product);

        ProductPage productPage = new ProductPage(getDriver());
        productPage.addProductToCart();
        productPage.proceedToCart();

        OrderPage orderPage = new OrderPage(getDriver());
        softly.assertThat(orderPage.getUrl()).contains(orderPage.getPageUrlFragment());

        orderPage.confirmProductCheckout();
        orderPage.confirmAddress();
        orderPage.confirmShipping();
        orderPage.selectPaymentType();

        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(getDriver());
        softly.assertThat(orderConfirmationPage.getOrderConfirmationHeading().getText()).isEqualTo(expectedValues.get("orderConfirmationTitle"));
        softly.assertThat(orderConfirmationPage.getShippingDoneTab().isDisplayed()).isTrue();
        softly.assertThat(orderConfirmationPage.getPaymentTab().isDisplayed()).isTrue();
        softly.assertThat(orderConfirmationPage.getOrderConfirmationLabel().getText()).contains(expectedValues.get("orderConfirmationMessage"));
        softly.assertThat(orderConfirmationPage.getUrl()).contains(orderConfirmationPage.getPageUrlFragment());
        softly.assertAll();
    }
}

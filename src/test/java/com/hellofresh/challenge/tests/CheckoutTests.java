package com.hellofresh.challenge.tests;

import com.hellofresh.challenge.pages.pageObjects.*;
import com.hellofresh.challenge.utils.TestDataProvider;
import com.hellofresh.challenge.utils.extentReports.ExtentManager;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import java.util.Map;

public class CheckoutTests extends BaseTest {

    @Test(dataProvider = "product-data-provider",
            dataProviderClass = TestDataProvider.class,
            description = "Validate that existing user can place an order successfully.")
    public void checkoutTest(Map<String, String> authData, String product) {
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
        softly.assertThat(orderConfirmationPage.getUrl()).contains(orderConfirmationPage.getPageUrlFragment());
        softly.assertThat(orderConfirmationPage.getOrderConfirmationHeading().getText()).isEqualTo("ORDER CONFIRMATION");
        softly.assertThat(orderConfirmationPage.getShippingDoneTab().isDisplayed()).isTrue();
        softly.assertThat(orderConfirmationPage.getPaymentTab().isDisplayed()).isTrue();
        softly.assertThat(orderConfirmationPage.getOrderConfirmationLabel().getText()).contains("Your order on My Store is complete.");
    }
}

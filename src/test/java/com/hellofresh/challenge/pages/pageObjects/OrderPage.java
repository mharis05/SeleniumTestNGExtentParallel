package com.hellofresh.challenge.pages.pageObjects;

import com.hellofresh.challenge.pages.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Order steps Page object
 */
public class OrderPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(OrderPage.class);

    public WebElement getCheckoutButton() {
        return getElement(checkoutButton);
    }

    private By checkoutButton = By.xpath("//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']");
    private By confirmAddressButton = By.name("processAddress");
    private By serviceTermsCheckbox = By.id("uniform-cgv");
    private By confirmShippingButton = By.name("processCarrier");
    private By paymentTypeButton = By.className("bankwire");
    private By confirmPaymentButton = By.xpath("//*[@id='cart_navigation']/button");

    public OrderPage(WebDriver driver) {
        super(driver);
        urlFragment = "order";
        getElementByVisibility(checkoutButton);
    }


    public WebElement getConfirmAddressButton() {
        return getElement(confirmAddressButton);
    }

    public WebElement getServiceTermsCheckbox() {
        return getElement(serviceTermsCheckbox);
    }

    public WebElement getConfirmShippingButton() {
        return getElement(confirmShippingButton);
    }

    public WebElement getPaymentTypeButton() {
        return getElement(paymentTypeButton);
    }

    public WebElement confirmPaymentTypeButton() {
        return getElement(confirmPaymentButton);
    }

    public void confirmProductCheckout() {
        getElement(checkoutButton).click();
    }

    public void confirmAddress() {
        getConfirmAddressButton().click();
    }

    /**
     * Confirm shipping steps on Order page
     */
    public void confirmShipping() {
        logger.info("Confirming service terms");
        getServiceTermsCheckbox().click();
        logger.info("Confirming shipping");
        getConfirmShippingButton().click();
    }

    /**
     * Confirm payment steps on Order Page
     */
    public void selectPaymentType() {
        logger.info("Confirming payment type");
        getPaymentTypeButton().click();
        confirmPaymentTypeButton().click();
    }
}

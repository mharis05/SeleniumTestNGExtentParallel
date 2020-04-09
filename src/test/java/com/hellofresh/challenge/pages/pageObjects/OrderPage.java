package com.hellofresh.challenge.pages.pageObjects;

import com.hellofresh.challenge.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage extends BasePage {

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

    public void confirmShipping() {
        getServiceTermsCheckbox().click();
        getConfirmShippingButton().click();
    }

    public void selectPaymentType() {
        getPaymentTypeButton().click();
        confirmPaymentTypeButton().click();
    }
}

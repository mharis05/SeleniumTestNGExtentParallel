package com.hellofresh.challenge.pages.pageObjects;

import com.hellofresh.challenge.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage extends BasePage {

    public WebElement getCheckoutButton() {
        return getElement(checkoutButton);
    }

    public By getConfirmAddressButton() {
        return confirmAddressButton;
    }

    public By getServiceTermsCheckbox() {
        return serviceTermsCheckbox;
    }

    public By getConfirmShippingButton() {
        return confirmShippingButton;
    }

    public By getPaymentTypeButton() {
        return paymentTypeButton;
    }


    By checkoutButton = By.xpath("//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']");
    By confirmAddressButton = By.name("processAddress");
    By serviceTermsCheckbox = By.id("uniform-cgv");
    By confirmShippingButton = By.name("processCarrier");
    By paymentTypeButton = By.className("bankwire");
    By confirmPaymentButton = By.xpath("//*[@id='cart_navigation']/button");



    public OrderPage(WebDriver driver) {
        super(driver);
        urlFragment = "order";
        getElementByVisibility(checkoutButton);
    }

    public void confirmProductCheckout() {
        getElement(checkoutButton).click();
    }

    public void confirmAddress() {
        getElement(confirmAddressButton).click();
    }

    public void confirmShipping() {
        getElement(serviceTermsCheckbox).click();
        getElement(confirmShippingButton).click();
    }

    public void selectPaymentType() {
        getElement(paymentTypeButton).click();
    }
}

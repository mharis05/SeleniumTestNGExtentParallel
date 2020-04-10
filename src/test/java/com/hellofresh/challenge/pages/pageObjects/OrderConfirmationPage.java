package com.hellofresh.challenge.pages.pageObjects;

import com.hellofresh.challenge.pages.BasePage;
import com.hellofresh.challenge.tests.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Order confirmation page object
 */
public class OrderConfirmationPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(OrderConfirmationPage.class);

    private By orderConfirmationHeading = By.cssSelector("h1");
    private By shippingDoneTab = By.xpath("//li[@class='step_done step_done_last four']");
    private By paymentTab = By.xpath("//li[@id='step_end' and @class='step_current last']");
    private By orderConfirmationLabel = By.xpath("//*[@class='cheque-indent']/strong");

    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
        urlFragment = "order-confirmation";
        getElementByVisibility(orderConfirmationHeading);
    }

    public WebElement getOrderConfirmationHeading() {
        return getElement(orderConfirmationHeading);
    }

    public WebElement getShippingDoneTab() {
        return getElement(shippingDoneTab);
    }

    public WebElement getPaymentTab() {
        return getElement(paymentTab);
    }

    public WebElement getOrderConfirmationLabel() {
        return getElement(orderConfirmationLabel);
    }
}

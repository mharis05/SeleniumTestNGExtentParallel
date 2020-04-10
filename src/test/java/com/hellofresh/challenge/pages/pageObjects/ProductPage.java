package com.hellofresh.challenge.pages.pageObjects;

import com.hellofresh.challenge.pages.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Product details page object
 */
public class ProductPage extends BasePage {

    private static Logger logger = Logger.getLogger(ProductPage.class.getName());

    private By priceText = By.id("our_price_display");
    private By addToCartButton = By.name("Submit");
    private By checkOutButton = By.xpath("//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']");

    public ProductPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        urlFragment = "product";
        getElementByPresence(priceText);
    }

    /**
     * Step to add product to Cart
     */
    public void addProductToCart() {
        getElement(addToCartButton).click();
    }
    /**
     * Step to add product to Cart
     */
    public void proceedToCart() {
        getElementByVisibility(checkOutButton).click();
    }
}

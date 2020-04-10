package com.hellofresh.challenge.pages.pageObjects;

import com.hellofresh.challenge.pages.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Category Items Page object
 */
public class CategoryItemsPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(CategoryItemsPage.class);

    private By categoryLink = By.className("cat-name");
    // Locator defined as String to use it flexibly for multiple elements.
    private String productNameLink = "//a[@title='name_placeholder'][@class='product-name']";

    public CategoryItemsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        urlFragment = "my-account";
        getElementByVisibility(categoryLink);
    }

    /**
     * This method can be used to select any product visible on the page
     * by product name
     * @param name product name String
     */
    public void selectProduct(String name) {
        logger.info("Selecting product: " + name);
        productNameLink = productNameLink.replace("name_placeholder", name);
        getElementByVisibility(By.xpath(productNameLink)).click();

    }


}

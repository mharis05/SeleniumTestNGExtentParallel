package com.hellofresh.challenge.pages.pageObjects;

import com.hellofresh.challenge.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryItemsPage extends BasePage {

    private By categoryLink = By.className("cat-name");
    private String productNameLink = "//a[@title='name_placeholder'][@class='product-name']";

    public CategoryItemsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        urlFragment = "my-account";
        getElementByVisibility(categoryLink);
    }

    public void selectProduct(String name) {
        productNameLink = productNameLink.replace("name_placeholder", name);
        getElementByVisibility(By.xpath(productNameLink)).click();

    }


}

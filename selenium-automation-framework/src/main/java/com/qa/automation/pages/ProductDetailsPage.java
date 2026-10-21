package com.qa.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.automation.base.BasePage;

public class ProductDetailsPage extends BasePage {

    private By productName =
            By.className("inventory_details_name");

    private By productPrice =
            By.className("inventory_details_price");

    private By backToProductsButton =
            By.id("back-to-products");

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return getText(productName);
    }

    public String getProductPrice() {
        return getText(productPrice);
    }

    public void clickBackToProducts() {
        click(backToProductsButton);
    }
}
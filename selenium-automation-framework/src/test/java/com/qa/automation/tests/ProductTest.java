package com.qa.automation.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.automation.pages.ProductDetailsPage;
import com.qa.automation.pages.ProductsPage;
import com.qa.automation.utils.DriverFactory;

public class ProductTest extends BaseTest {

    @Test
    public void verifyProductsPageDisplayed() {

        WebDriver driver = DriverFactory.getDriver();

        loginToApplication();

        ProductsPage productsPage =
                new ProductsPage(driver);

        Assert.assertEquals(
                productsPage.getPageTitle(),
                "Products",
                "Products page was not displayed"
        );
    }

    @Test
    public void verifyProductsCanBeSortedByPriceLowToHigh() {

        WebDriver driver = DriverFactory.getDriver();

        loginToApplication();

        ProductsPage productsPage =
                new ProductsPage(driver);

        productsPage.sortProductsBy("lohi");

        Assert.assertEquals(
                productsPage.getProductPrices()
                        .get(0)
                        .getText(),
                "$7.99",
                "Products were not sorted by price correctly"
        );
    }
    
    @Test
    public void verifyProductDetails() {

        WebDriver driver = DriverFactory.getDriver();

        loginToApplication();

        ProductsPage productsPage =
                new ProductsPage(driver);

        productsPage.clickProduct("Sauce Labs Backpack");

        ProductDetailsPage productDetailsPage =
                new ProductDetailsPage(driver);

        Assert.assertEquals(
                productDetailsPage.getProductName(),
                "Sauce Labs Backpack",
                "Incorrect product name"
        );

        Assert.assertEquals(
                productDetailsPage.getProductPrice(),
                "$29.99",
                "Incorrect product price"
        );
    }
}
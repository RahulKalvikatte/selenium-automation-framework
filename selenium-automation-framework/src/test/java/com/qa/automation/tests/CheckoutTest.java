package com.qa.automation.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.automation.pages.CartPage;
import com.qa.automation.pages.CheckoutPage;
import com.qa.automation.pages.ProductsPage;
import com.qa.automation.utils.ConfigReader;
import com.qa.automation.utils.DriverFactory;

public class CheckoutTest extends BaseTest {

    @Test
    public void verifyCheckoutOverview() {

        WebDriver driver = DriverFactory.getDriver();

        loginToApplication();

        ProductsPage productsPage =
                new ProductsPage(driver);

        productsPage.addBackpackToCart();

        CartPage cartPage =
                new CartPage(driver);

        cartPage.openCart();

        CheckoutPage checkoutPage =
                new CheckoutPage(driver);

        checkoutPage.clickCheckout();

        checkoutPage.enterCustomerInformation(
        		ConfigReader.getProperty("firstName"),
                ConfigReader.getProperty("lastName"),
                ConfigReader.getProperty("postalCode")
        );

        checkoutPage.clickContinue();

        Assert.assertEquals(
                checkoutPage.getCheckoutOverviewTitle(),
                "Checkout: Overview",
                "Checkout overview page was not displayed"
        );
        
        checkoutPage.clickFinish();

        Assert.assertEquals(
                checkoutPage.getOrderConfirmationMessage(),
                "Thank you for your order!",
                "Order confirmation message was not displayed"
        );
    }
}
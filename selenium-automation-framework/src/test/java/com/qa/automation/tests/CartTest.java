package com.qa.automation.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.automation.pages.CartPage;
import com.qa.automation.pages.ProductsPage;
import com.qa.automation.utils.DriverFactory;

public class CartTest extends BaseTest {
	
	@Test
	public void verifyProductCanBeAddedToCart() {
		WebDriver driver = DriverFactory.getDriver();
		
		loginToApplication();
		 
		 ProductsPage productsPage =new ProductsPage(driver);
		 
		 productsPage.addBackpackToCart();
		 
		 CartPage cartPage = new CartPage(driver);
		 
		 cartPage.openCart();
		 
		 Assert.assertEquals(
				 cartPage.getCartItemName(),
				 "Sauce Labs Backpack",
	             "Incorrect product displayed in cart");
		
	}
	
	@Test
    public void verifyProductDisplayedInCart() {

        WebDriver driver = DriverFactory.getDriver();

        loginToApplication();
        ProductsPage productsPage =
                new ProductsPage(driver);

        productsPage.addBackpackToCart();

        CartPage cartPage =
                new CartPage(driver);

        cartPage.openCart();

        Assert.assertEquals(
                cartPage.getCartItemName(),
                "Sauce Labs Backpack",
                "Incorrect product displayed in cart"
        );
    }
	
	@Test
	public void verifyProductCanBeRemovedFromCart() {

	    WebDriver driver = DriverFactory.getDriver();

	    loginToApplication();

	    ProductsPage productsPage =
	            new ProductsPage(driver);

	    productsPage.addBackpackToCart();

	    CartPage cartPage =
	            new CartPage(driver);

	    cartPage.openCart();

	    cartPage.removeBackpack();

	    Assert.assertFalse(
	            cartPage.isCartItemDisplayed(),
	            "Product was not removed from cart"
	    );
	}

}

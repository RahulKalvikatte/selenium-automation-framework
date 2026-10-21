package com.qa.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.automation.base.BasePage;

public class CartPage extends BasePage{
	
	private By cartLink = By.className("shopping_cart_link");
	
	private By cartItemName = By.className("inventory_item_name");
	
	private By removeButton =
	        By.cssSelector("[data-test='remove-sauce-labs-backpack']");
	
	
	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	public void openCart() {
		click(cartLink);
	}
	
	public String getCartItemName() {
		return getText(cartItemName);
	}
	
	public void removeBackpack() {
	        click(removeButton);
	}
	
	public boolean isCartItemDisplayed() {
        return driver.findElements(cartItemName).size() > 0;
    }
	
}

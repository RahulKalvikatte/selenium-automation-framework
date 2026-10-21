package com.qa.automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.qa.automation.base.BasePage;

public class ProductsPage extends BasePage {

    private By pageTitle = By.className("title");
    
    private By firstProduct =
            By.className("inventory_item_name");

    private By sortDropdown =
            By.className("product_sort_container");

    private By productNames =
            By.className("inventory_item_name");

    private By productPrices =
            By.className("inventory_item_price");
    
    private By backpackAddToCart = By.id("add-to-cart-sauce-labs-backpack");
	
	private By cartBadge = By.className("shopping_cart_badge");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return getText(pageTitle);
    }
    
    public void clickFirstProduct() {

        click(firstProduct);
    }
    
    public void addBackpackToCart() {
        click(backpackAddToCart);
    }

    public String getCartItemCount() {
        return getText(cartBadge);
    }

    public void sortProductsBy(String option) {

        WebElement dropdown =
                waitForElementVisible(sortDropdown);

        Select select = new Select(dropdown);

        select.selectByValue(option);
    }

    public List<WebElement> getProductNames() {

        return driver.findElements(productNames);
    }

    public List<WebElement> getProductPrices() {

        return driver.findElements(productPrices);
    }
}
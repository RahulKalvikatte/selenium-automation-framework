package com.qa.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.automation.base.BasePage;

public class CheckoutPage extends BasePage{
	
	private By checkoutButton =
            By.id("checkout");

    private By firstNameField =
            By.id("first-name");

    private By lastNameField =
            By.id("last-name");

    private By postalCodeField =
            By.id("postal-code");

    private By continueButton =
            By.id("continue");

    private By checkoutOverviewTitle =
            By.className("title");
    
    private By finishButton =
            By.id("finish");

    private By orderConfirmationMessage =
            By.className("complete-header");
	
	public CheckoutPage(WebDriver driver) {
		super (driver);
	}
	
	public void clickCheckout() {
		click(checkoutButton);
	}
	
	public void enterFirstName(String firstName) {
        enterText(firstNameField, firstName);
    }

    public void enterLastName(String lastName) {
        enterText(lastNameField, lastName);
    }

    public void enterPostalCode(String postalCode) {
        enterText(postalCodeField, postalCode);
    }

    public void clickContinue() {
        click(continueButton);
    }

    public void enterCustomerInformation(
            String firstName,
            String lastName,
            String postalCode) {

        enterFirstName(firstName);
        enterLastName(lastName);
        enterPostalCode(postalCode);
    }

    public String getCheckoutOverviewTitle() {
        return getText(checkoutOverviewTitle);
    }
    
    public void clickFinish() {
        click(finishButton);
    }

    public String getOrderConfirmationMessage() {
        return getText(orderConfirmationMessage);
    }
}

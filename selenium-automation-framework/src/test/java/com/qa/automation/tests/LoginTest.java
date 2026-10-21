package com.qa.automation.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.automation.pages.LoginPage;
import com.qa.automation.utils.ConfigReader;
import com.qa.automation.utils.DriverFactory;

public class LoginTest extends BaseTest{
	
	@DataProvider(name="loginData")
	public Object[][] loginData(){
		
		return new Object[][] {
            {"standard_user", "secret_sauce", true},
            {"locked_out_user", "secret_sauce", false},
            {"invalid_user", "wrong_password", false}
        };
	}
	@Test(dataProvider ="loginData")
	public void verifyValidLogin(String username,String password ,boolean expectedSuccess) {
		WebDriver driver=DriverFactory.getDriver();
		driver.get(ConfigReader.getProperty("baseUrl"));
		LoginPage loginPage=new LoginPage(driver);
		
		
		loginPage.login(username,password);
		
		if (expectedSuccess) {
			Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"),
                    "User should be logged in successfully");
		}
		else {
			Assert.assertTrue(
                    loginPage.isErrorMessageDisplayed(),
                    "Error message should be displayed for invalid login"
            );
		}
	}
}

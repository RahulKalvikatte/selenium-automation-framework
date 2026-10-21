package com.qa.automation.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.qa.automation.pages.LoginPage;
import com.qa.automation.utils.ConfigReader;
import com.qa.automation.utils.DriverFactory;

public class BaseTest {
	
	
	@BeforeMethod
	public void setUp() {
		DriverFactory.initializeDriver();
	}
	
	@AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
	
	 protected void loginToApplication() {

	        WebDriver driver = DriverFactory.getDriver();

	        driver.get(
	                ConfigReader.getProperty("baseUrl")
	        );

	        LoginPage loginPage =
	                new LoginPage(driver);

	        loginPage.login(
	                ConfigReader.getProperty("username"),
	                ConfigReader.getProperty("password")
	        );
	    }

}

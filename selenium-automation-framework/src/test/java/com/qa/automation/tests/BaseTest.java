package com.qa.automation.tests;

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

    protected void openApplication() {

        DriverFactory.getDriver().get(
        		ConfigReader.getBaseUrl()
        );
    }

    protected void loginToApplication() {

        openApplication();

        LoginPage loginPage =
                new LoginPage(DriverFactory.getDriver());

        loginPage.login(
        		ConfigReader.getUsername(),
        		ConfigReader.getPassword()
        );
    }
}
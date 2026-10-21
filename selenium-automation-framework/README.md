# Selenium Automation Framework

A maintainable UI automation testing framework built using Java, Selenium WebDriver, TestNG, Maven, and Page Object Model (POM).

## Project Overview

This project automates functional test scenarios for the SauceDemo web application.

The framework follows the Page Object Model design pattern and provides reusable page classes, centralized WebDriver management, configuration handling, TestNG execution, screenshots on test failure, and Extent Reports.

## Tech Stack

- Java 22
- Selenium WebDriver 4.35.0
- TestNG 7.11.0
- Maven
- Page Object Model (POM)
- Extent Reports
- Git & GitHub
- Eclipse IDE

## Application Under Test

SauceDemo

https://www.saucedemo.com/

## Framework Structure

```text
selenium-automation-framework
│
├── src
│   ├── main
│   │   └── java
│   │       └── com.qa.automation
│   │           ├── base
│   │           │   └── BasePage.java
│   │           │
│   │           ├── pages
│   │           │   ├── LoginPage.java
│   │           │   ├── ProductsPage.java
│   │           │   ├── ProductDetailsPage.java
│   │           │   ├── CartPage.java
│   │           │   └── CheckoutPage.java
│   │           │
│   │           └── utils
│   │               ├── ConfigReader.java
│   │               ├── DriverFactory.java
│   │               └── ScreenshotUtil.java
│   │
│   └── test
│       ├── java
│       │   └── com.qa.automation
│       │       ├── listeners
│       │       │   └── TestListener.java
│       │       ├── reports
│       │       │   └── ExtentReportManager.java
│       │       └── tests
│       │           ├── BaseTest.java
│       │           ├── LoginTest.java
│       │           ├── ProductTest.java
│       │           ├── CartTest.java
│       │           └── CheckoutTest.java
│       │
│       └── resources
│           └── config.properties
│
├── screenshots/
├── reports/
├── pom.xml
├── testng.xml
└── .gitignore
package com.qa.automation.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.automation.reports.ExtentReportManager;
import com.qa.automation.utils.ScreenshotUtil;

public class TestListener implements ITestListener, ISuiteListener {

    private static ExtentReports extentReports;
    private static ThreadLocal<ExtentTest> extentTest =
            new ThreadLocal<>();

    @Override
    public void onStart(ISuite suite) {

        extentReports =
                ExtentReportManager.getReportInstance();

        System.out.println(
                "Extent report initialized."
        );
    }

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest test =
                extentReports.createTest(
                        result.getTestClass()
                                .getName()
                                + " - "
                                + result.getMethod()
                                        .getMethodName()
                );

        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        extentTest.get()
                .pass("Test passed successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        String testName = result.getName();

        String screenshotPath =
                ScreenshotUtil.captureScreenshot(testName);

        extentTest.get()
                .fail(result.getThrowable());

        extentTest.get()
                .addScreenCaptureFromPath(
                        screenshotPath
                );

        System.out.println(
                "Screenshot captured for failed test: "
                        + testName
        );
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        extentTest.get()
                .skip("Test was skipped");
    }

    @Override
    public void onFinish(ISuite suite) {

        if (extentReports != null) {

            extentReports.flush();

            System.out.println(
                    "Extent report generated successfully."
            );
        }
    }
}
package com.cutanddry.qa.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.util.ArrayList;
import java.util.List;

import static com.cutanddry.qa.common.Constants.TEST_ENV;

public class TestNGListener implements ITestListener {
    private int totalTests = 0;
    private int passedTests = 0;
    private int failedTests = 0;
    private List<String> passedTestCases = new ArrayList<>();
    private List<String> failedTestCases = new ArrayList<>();
    private String DP;

    @Override
    public void onTestStart(ITestResult result) {
        totalTests++;
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        passedTests++;
        passedTestCases.add(result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        failedTests++;
        failedTestCases.add(result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
//        String environment = System.getProperty("test.env", "uat");
        SlackNotifier.sendSlackAlert(totalTests, passedTests, failedTests, TEST_ENV, passedTestCases, failedTestCases, DP);
        totalTests = 0;
        passedTests = 0;
        failedTests = 0;
        passedTestCases = new ArrayList<>();
        failedTestCases = new ArrayList<>();
    }

    // Implement other ITestListener methods if needed
    @Override
    public void onTestSkipped(ITestResult result) {
        // Optional: handle skipped tests
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Optional: handle tests that failed but are within success percentage
    }

    @Override
    public void onStart(ITestContext context) {
        // Retrieve the DP Name from the test parameters
        DP = context.getCurrentXmlTest().getParameter("DP");
    }
}

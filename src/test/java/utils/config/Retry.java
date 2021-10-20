package utils.config;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import tests.gmail.TestBase;
import utils.ExtendReport.ExtendTestManager;
import utils.common.Constants;
import utils.common.Util;

public class Retry implements IRetryAnalyzer {
	private int count = 0;
	private static int maxTry = 1; // Run the failed test 2 times

	public boolean retry(ITestResult iTestResult) {
		if (!iTestResult.isSuccess()) { // Check if test not succeed
			if (count < maxTry) { // Check if maxTry count is reached
				count++; // Increase the maxTry count by 1
				iTestResult.setStatus(ITestResult.FAILURE); // Mark test as failed and take base64Screenshot
				extendReportsFailOperations(iTestResult); // ExtentReports fail operations
				return true; // Tells TestNG to re-run the test
			}
		} else {
			iTestResult.setStatus(ITestResult.SUCCESS); // If test passes, TestNG marks it as passed
		}
		return false;
	}

	public void extendReportsFailOperations(ITestResult iTestResult) {
		Object testClass = iTestResult.getInstance();
		WebDriver webDriver = ((TestBase) testClass).getDriver();
		String screenshotPath = Util.getScreenShot(Constants.WEBDRIVER, iTestResult.getName());
		try {
			ExtendTestManager.getTest().fail("Test Case Failed Snapshot is below " + ExtendTestManager.getTest().addScreenCaptureFromPath(screenshotPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

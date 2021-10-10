package utils.config;


import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import utils.ExtendReport.ExtendManager;
import utils.ExtendReport.ExtendTestManager;
import utils.common.Constants;
import utils.common.Util;
import utils.helper.Logger;

public class TestListener implements ITestListener {
	
	public void onTestFailure(ITestResult result) {
		ExtendTestManager.getTest().log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
		String screenshotPath = Util.getScreenShot(Constants.WEBDRIVER, result.getName());
		screenshotPath.replace(".0", ".1");
		try {
			ExtendTestManager.getTest().fail("Test Case Failed Snapshot is below " + ExtendTestManager.getTest().addScreenCaptureFromPath(screenshotPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ExtendTestManager.getTest().fail(e.getLocalizedMessage());
		}
	}
	
	public void onTestStart(ITestResult result) {
		Logger.info("Starting test case: "+ result.getMethod().getMethodName());
	}
	
	public void onTestSuccess(ITestResult result) {
		ExtendTestManager.getTest().log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
	}

	public void onTestSkipped(ITestResult result) {
		ExtendTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
	}

	public void onFinish(ITestContext context) {
		ExtendManager.extentReports.flush();
	}
}

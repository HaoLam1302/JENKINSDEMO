package utils.config;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Allure;
import utils.common.Constants;
import utils.helper.Logger;

public class TestListener implements ITestListener {

	public void onTestFailure(ITestResult result) {
		Logger.fail("TEST FAILED");
		if (Constants.WEBDRIVER != null) {
			File screenshotAs = ((TakesScreenshot) Constants.WEBDRIVER).getScreenshotAs(OutputType.FILE);
			try {
				Allure.addAttachment("Fail screenshot", FileUtils.openInputStream(screenshotAs));
			} catch (IOException e) {
				e.printStackTrace();
				Logger.fail(e.getLocalizedMessage());
			}
		}
	}

	public void onTestStart(ITestResult result) {
		Logger.info(String.format("TEST CASE: %s.%s", result.getTestClass().getName(), result.getName()).replace("_",
				"_ "));
	}

	public void onTestSuccess(ITestResult result) {
		Logger.pass("Test passed.");
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("TEST SKIP");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
	}

	public void onFinish(ITestContext context) {
	}
}

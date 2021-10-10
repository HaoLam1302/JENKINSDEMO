package utils.config;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import utils.common.Constants;

public class Utilities {
	public static String screenshotPath;
	public static String screenshotName;

	public static void captureScreenshot() throws IOException {

		File scrFile = ((TakesScreenshot) Constants.WEBDRIVER).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".png";

		FileUtils.copyFile(scrFile,
				
		new File(System.getProperty("user.dir") + "/target/surefire-reports/html/" + screenshotName));
		screenshotPath= System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName;

		
	}
}

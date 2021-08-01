package utils.common;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.helper.Logger;

public class Common {

	public static WebElement findElement(By locator) {
		WebDriverWait wait = new WebDriverWait(Constants.WEBDRIVER, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return Constants.WEBDRIVER.findElement(locator);
	}

	public static List<WebElement> findElements(By locator) {
		WebDriverWait wait = new WebDriverWait(Constants.WEBDRIVER, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return Constants.WEBDRIVER.findElements(locator);
	}
	
	public static boolean checkElementNotExist(By locator) {
		WebDriverWait wait = new WebDriverWait(Constants.WEBDRIVER, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		int lenght = Constants.WEBDRIVER.findElements(locator).size();
		if( lenght != 0) {
			return false;
		}else {
			return true;
		}

	}
	
	public static File getScreenshot(By by, int staleTimeout) {
		try {
			WebDriverWait wait = new WebDriverWait(Constants.WEBDRIVER, Duration.ofSeconds(10));
			return (wait.until(ExpectedConditions.presenceOfElementLocated(by)).getScreenshotAs(OutputType.FILE));
		} catch (StaleElementReferenceException e) {
			Logger.info("Common.getScreenshot getting StaleElementReferenceException: " + by.toString());
			if (staleTimeout <= 0) {
				Logger.info(e.getLocalizedMessage());
				throw e;
			} else {
				Util.sleep(1000);
				return getScreenshot(by, staleTimeout - 1);
			}
		}
	}
	
	public static String getNowTime(String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		Date date = new Date();
		return dateFormat.format(date);
	}

}

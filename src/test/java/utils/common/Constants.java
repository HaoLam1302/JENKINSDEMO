package utils.common;

import org.openqa.selenium.WebDriver;

import utils.helper.PropertiesHelper;

public class Constants {
	public static WebDriver WEBDRIVER;
	
	public static final String URL = PropertiesHelper.getPropValue("url");
	
	public static final String USERNAME = PropertiesHelper.getPropValue("user.username");
	public static final String PASSWORD = PropertiesHelper.getPropValue("user.password");
	
	
	public static final String DATA_FOLDER = System.getProperty("user.dir") + System.getProperty("file.separator")
	+ "src" + System.getProperty("file.separator") + "test" + System.getProperty("file.separator")
	+ "resources";

	public static final String LIST_ACCOUNT = DATA_FOLDER + System.getProperty("file.separator") + "dataObjects" + System.getProperty("file.separator") + "Account.json";
}

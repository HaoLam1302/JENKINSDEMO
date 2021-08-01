package utils.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


public class Util {

	public static String getProjectPath() {
		String userDirectory = System.getProperty("user.dir");
		return userDirectory;
	}

	public static String randomString(int length, String type) {
		String AlphaNumericString = "";
		if (type == "string" || type == "String") {
			AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
		} else if (type == "number" || type == "Number") {
			AlphaNumericString = "0123456789";
		}

		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index = (int) (AlphaNumericString.length() * Math.random());
			// add Character one by one in end of sb
			sb.append(AlphaNumericString.charAt(index));
		}
		return sb.toString();
	}

	public static void switchToNewWindow() {
		// Switch to new window opened
		for (String winHandle : Constants.WEBDRIVER.getWindowHandles()) {
			Constants.WEBDRIVER.switchTo().window(winHandle);
		}
	}

	public static String convertObjectToString(Object obj) {
		Gson gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
		String str = new Gson().toJson(obj);
		JsonElement je = JsonParser.parseString(str);
		return gson.toJson(je);
	}

	public static void sleep(int milisecond) {
		try {
			Thread.sleep(milisecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


//	public static String captureImage(Element element) {
//		String elementImageName = UUID.randomUUID().toString() + ".png";
//		element.waitForVisibility(Constants.SHORT_TIME);
//		File scrFile = element.getElement().getScreenshotAs(OutputType.FILE);
//		File outputfile = new File(getCompareFolder(true) + System.getProperty("file.separator") + elementImageName);
//
//		try {
//			ImageIO.write(ImageIO.read(scrFile), "png", outputfile);
//			return elementImageName;
//		} catch (IOException e) {
//			Logger.info(e.getLocalizedMessage());
//			throw new IllegalArgumentException(e.getLocalizedMessage());
//		}
//	}


//	public static String getCompareFolder(boolean fullPath) {
//		String resultPath = getProjectPath() + System.getProperty("file.separator") + "allure-results";
//		createFolter(resultPath);
//		if (comparePath.isEmpty()) {
//			compareShortPath = "Compare Folder - " + (Common.getNowTime("MM.dd.yyyy - HH.mm.ss"));
//			comparePath = resultPath + System.getProperty("file.separator") + compareShortPath;
//		}
//		createFolter(comparePath);
//		if (fullPath) {
//			return comparePath;
//		} else {
//			return "allure-results" + System.getProperty("file.separator") + compareShortPath;
//		}
//	}
//
//	public static void createFolter(String path) {
//		File filePath = new File(path);
//		if (!filePath.exists()) {
//			filePath.mkdir();
//		}
//	}
//
//	public static String screenshotEntryScreen(String filename) {
//		String fileName = filename + "_" + UUID.randomUUID().toString();
//		fileName = Driver.captureScreenshot(fileName, getCompareFolder(false));
//		return fileName;
//	}
}

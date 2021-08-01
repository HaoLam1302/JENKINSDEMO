package utils.helper;

import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;

public class Logger {
	private static final Log log = LoggerFactory.getLog(Logger.class);

	public static void info(String message) {
		log.info(message);
		Allure.step(message);
	}

//	public static void reportImg(String message) {
//		String fileNamePath = Util.screenshotEntryScreen(message);
//		try {
//			Allure.addAttachment(message, new FileInputStream(fileNamePath));
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//			Logger.warning(e.getLocalizedMessage());
//		}
//	}

	public static void bug(String bugId, String bugLink) {
		String bugInfo = String.format("The bug %s-%s is added", bugId, bugLink);
		log.error(bugInfo);
		String msg = "<a target=\"_blank\" href=\"" + bugLink
				+ "\" style=\"color:#DF0101;font-size:14px;word-break:break-word;\">" + bugInfo + "</a>";
		Allure.step(msg, Status.BROKEN);
	}

	public static void verify(String message) {
		log.verify(message);
		Allure.step("VERIFY POINT: " + message);
	}

	public static void warning(String message) {
		log.warn(message);
		Allure.step(message, Status.BROKEN);
	}

	public static void pass(String message) {
		log.info("PASS: " + message);
		Allure.step(message, Status.PASSED);
	}

	public static void fail(String message) {
		log.info("FAIL: " + message);
		Allure.step(message, Status.FAILED);
	}

}

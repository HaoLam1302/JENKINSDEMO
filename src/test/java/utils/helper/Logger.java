package utils.helper;

import utils.ExtendReport.ExtendTestManager;


public class Logger {
	private static final Log log = LoggerFactory.getLog(Logger.class);
	
	public static void info(String message) {
		System.out.println(message);
		ExtendTestManager.getTest().info(message);
		
	}

	public static void bug(String bugId, String bugLink) {
		String bugInfo = String.format("The bug %s-%s is added", bugId, bugLink);
		log.error(bugInfo);
		String msg = "<a target=\"_blank\" href=\"" + bugLink
				+ "\" style=\"color:#DF0101;font-size:14px;word-break:break-word;\">" + bugInfo + "</a>";
	}

	public static void verify(String message) {
		System.out.println(message);
		log.verify(message);
		ExtendTestManager.getTest().info(message);
		
	}

	public static void warning(String message) {
		log.warn(message);
		
	}

}

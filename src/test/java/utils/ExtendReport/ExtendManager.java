package utils.ExtendReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendManager {
	public static final ExtentReports extentReports = new ExtentReports();
	
	 public synchronized static ExtentReports createExtentReports() {
		 ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/ExtendReport/ExtentReport.html");
		 htmlReporter.config().setAutoCreateRelativePathMedia(true);
        	// Create an object of Extent Reports
		//extentReports = new ExtentReports();  
		extentReports.attachReporter(htmlReporter);
		extentReports.setSystemInfo("Host Name", "JenkinsTest");
		extentReports.setSystemInfo("Environment", "Production");
		extentReports.setSystemInfo("User Name", "JACKSON LAM");
		htmlReporter.config().setDocumentTitle("Result of this test suite"); 
                // Name of the report
		htmlReporter.config().setReportName("JACKSON REPORT"); 
                // Dark Theme
		htmlReporter.config().setTheme(Theme.STANDARD);		
		return extentReports;
	}
}

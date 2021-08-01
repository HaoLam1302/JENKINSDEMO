package tests.gmail;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import utils.base.PageObjectHelper;
import utils.common.Constants;
import utils.common.Util;

public class TestBase {
	@BeforeSuite
	public void beforeSuite() {
		System.setProperty("webdriver.chrome.driver",
				Util.getProjectPath() + "\\src\\test\\resources\\excutables\\chromedriver.exe");
		Constants.WEBDRIVER = new ChromeDriver();
		Constants.WEBDRIVER.manage().window().maximize();
		PageObjectHelper.loadPageObject(this);
	}

	@AfterSuite
	public void afterSuite() {
//		System.out.println("Post-condition");
//		// Here will compare if test is failing then only it will enter into if condition
//		if(ITestResult.FAILURE==result.getStatus()){
//			try {
//				// Create refernce of TakesScreenshot
//				TakesScreenshot ts=(TakesScreenshot)Constants.WEBDRIVER;
//				
//				// Call method to capture screenshot
//				File source=ts.getScreenshotAs(OutputType.FILE);
//		 
//				// Copy method  specific location here it will save all screenshot in our project home directory and
//				// result.getName() will return name of test case so that screenshot name will be same
//				try{
//					FileHandler.copy(source, new File(Util.getProjectPath() +"/src/test/resources/screenshots/"+result.getName()+".png"));
//					System.out.println("Screenshot taken");
//				}
//		
//				catch (Exception e){
//					System.out.println("Exception while taking screenshot "+e.getMessage());
//				} 
//			}catch (Exception e) {
//				// TODO: handle exception
//			}
//		}
		// close application
		Constants.WEBDRIVER.quit();
	}
}

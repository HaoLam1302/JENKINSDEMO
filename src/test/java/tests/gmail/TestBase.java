package tests.gmail;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utils.base.CapabilityFactory;
import utils.base.PageObjectHelper;
import utils.common.Constants;

public class TestBase {
	protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	public CapabilityFactory capabilityFactory = new CapabilityFactory();
	
	@BeforeMethod
	@Parameters(value={"browser"})
	public void setup (String browser) throws MalformedURLException {
//		System.setProperty("webdriver.chrome.driver",
//				Util.getProjectPath() + "\\src\\test\\resources\\org\\grid\\common\\drivers\\chromedriver.exe");
//		String hubURL ="http://localhost:4444/wd/hub"; 
//		DesiredCapabilities capabilites = new DesiredCapabilities(); 
//		capabilites.setBrowserName("chrome");
//		capabilites.setPlatform(Platform.WIN10);
//		ChromeOptions options = new ChromeOptions(); 
//		options.setAcceptInsecureCerts(true); 
//		options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
//		options.merge(capabilites); 
////		RemoteWebDriver drivers = new RemoteWebDriver(new URL(hubURL), options);
//        //Set Browser to ThreadLocalMap
//		driver.set(new RemoteWebDriver(new URL(hubURL), options));
		driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilityFactory.getCapabilities(browser)));
		Constants.WEBDRIVER = getDriver();
        PageObjectHelper.loadPageObject(this);
    }
//	@BeforeSuite
//	public void beforeSuite() {
//		//RUNLOCAL
//	//	driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilityFactory.getCapabilities(browser)));
//		System.setProperty("webdriver.chrome.driver",
//				Util.getProjectPath() + "\\src\\test\\resources\\excutables\\chromedriver.exe");
//		Constants.WEBDRIVER = new ChromeDriver();
//		Constants.WEBDRIVER.manage().window().maximize();
//		PageObjectHelper.loadPageObject(this);
//	}

	 public WebDriver getDriver() {
	        //Get driver from ThreadLocalMap
	        return driver.get();
	    }
	 
	@AfterMethod
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
		getDriver().quit();
	}
	
	@AfterClass void terminate () {
        //Remove the ThreadLocalMap element
        driver.remove();
    }
}

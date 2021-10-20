package tests.gmail;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import utils.ExtendReport.ExtendTestManager;
import utils.base.PageObjectHelper;
import utils.common.Constants;


public class TestBase {
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	@BeforeSuite
	@Parameters(value={"browser"})
	public void setup (String browser) throws MalformedURLException {
//		System.setProperty("webdriver.chrome.driver",
//				Util.getProjectPath() + "\\src\\test\\resources\\org\\grid\\common\\drivers\\chromedriver.exe");
//		String hubURL ="http://localhost:4444/wd/hub"; 
		DesiredCapabilities capabilites = new DesiredCapabilities(); 
		capabilites.setBrowserName(browser);
		ChromeOptions options = new ChromeOptions(); 
		options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        capabilites.setCapability(ChromeOptions.CAPABILITY, options);
////		RemoteWebDriver drivers = new RemoteWebDriver(new URL(hubURL), options);
//        //Set Browser to ThreadLocalMap
//		driver.set(new RemoteWebDriver(new URL(hubURL), options));
		driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilites));
		Constants.WEBDRIVER = driver.get();
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
	 
	
	@AfterClass void terminate () {
        //Remove the ThreadLocalMap element
        driver.remove();
    }
	
	
	@BeforeMethod
	public void startLog() {
		ExtendTestManager.startTest("Test","");
	}
	
	@AfterMethod
	public void getResult() {
		Constants.WEBDRIVER.quit();
	}
	

}

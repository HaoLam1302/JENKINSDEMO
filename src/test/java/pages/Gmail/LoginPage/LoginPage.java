package pages.Gmail.LoginPage;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.Gmail.GeneralPage.GeneralPage;
import utils.common.Common;
import utils.common.Constants;

public class LoginPage extends GeneralPage {
	
	// Locators
	private final By tbxUsername = By.xpath("//input[@type='email']");
	private final By tbxPassword = By.xpath("//input[@type='password']");
	private final By btnProvision = By.xpath("//a[text()='Điều khoản']");
	//Elements
	protected WebElement getTbxUsername() {
		return Common.findElement(tbxUsername);
	}

	protected WebElement getTbxPassword() {
		return Common.findElement(tbxPassword);
	}
	
	protected WebElement getBtnProvision() {
		return Common.findElement(btnProvision);
	}
	//Methods
	
	public void Login() {
		this.getTbxUsername().sendKeys(Constants.USERNAME);
		this.getTbxUsername().sendKeys(Keys.ENTER);
	}
	
	public boolean doesUserNameTextBoxDisplay() {
		return this.getTbxUsername().isDisplayed();
	}
	
	public boolean doesPasswordTextBoxDisplay() {
		return Common.checkElementNotExist(tbxPassword);
	}
	
	public void clickButtonProvision() {
		this.getBtnProvision().click();
	}
}

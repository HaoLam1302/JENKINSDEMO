package pages.Gmail.GeneralPage;

import java.util.Set;

import dataObjects.Account;
import utils.common.Constants;

public class GeneralPage {
	public void openGmailPage() {
		Constants.WEBDRIVER.navigate().to(Constants.URL);;
	}
	
	public void printAccounts(Account account) {
		int count =0;
		while(count++ <0) {
			System.out.println(account.getUsername());
			System.out.println(account.getPassword());
		}
	}
	
	public String getPageTitle() {
		return Constants.WEBDRIVER.getTitle();
	}
	
	
	public void switchToWindow(String windowName){
	String currentWindowString = Constants.WEBDRIVER.getWindowHandle();
	Set<String> allWindowList = Constants.WEBDRIVER.getWindowHandles();
	for( String window : allWindowList) {
		String windowString = Constants.WEBDRIVER.switchTo().window(window).getTitle();
		if(windowString.equals("Điều khoản dịch vụ của Google – Bảo mật và Điều khoản – Google")) {
		}
		else {
			Constants.WEBDRIVER.switchTo().window(currentWindowString);
		}
	}
	}
	
}

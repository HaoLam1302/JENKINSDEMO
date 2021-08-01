package tests.gmail;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import dataObjects.Account;
import pages.Gmail.GeneralPage.GeneralPage;
import pages.Gmail.LoginPage.LoginPage;
import utils.common.Constants;
import utils.config.TestListener;
import utils.helper.JsonHelper;
import utils.helper.Logger;

@Listeners({ TestListener.class })
public class Testsuite_Demo extends TestBase {
	GeneralPage generalPage;
	LoginPage loginPage;

	@Test(description = "TC01")
	public void TC01() {
		System.out.println("Running TC01");
		Logger.info("Step 1: Open web mail");
		generalPage.openGmailPage();

		loginPage.clickButtonProvision();
	

//		Logger.verify("Text box username is displayed");
//		assertTrue(loginPage.doesUserNameTextBoxDisplay(),"Textbox username is not displayed");

		Logger.verify("Text box password is displayed");
		assertTrue(loginPage.doesPasswordTextBoxDisplay(), "Password text box is not display");

		Logger.info("Step 2: Enter username");
		loginPage.Login();
	}
	
	@Test(description = "TC02")
	public void TC02() {
		System.out.println("Running TC02");
		Account[] account = JsonHelper.getData(Constants.LIST_ACCOUNT, Account[].class);

		System.out.print(account[1].getUsername());
//		for (Account accounts : account) {
//			generalPage.printAccounts(accounts);
//		}
	}
	
	@Test(description = "TC03")
	public void TC033() {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		
		System.out.println(list.size());
		System.out.println(list.get(1));
		
		
		
		int[] a = new int[1];
		a[0] = 1;
		a[1] =2;
		System.out.println(a.length);
				
	}
}

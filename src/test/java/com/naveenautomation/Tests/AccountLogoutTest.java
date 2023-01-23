package com.naveenautomation.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Pages.AccountLoginPage;
import com.naveenautomation.Pages.AccountLogoutPage;
import com.naveenautomation.Pages.MyAccountPage;
import com.naveenautomation.Pages.YourStorePage;

public class AccountLogoutTest extends TestBase {

	SoftAssert softAssert;
	YourStorePage yourStorePage;
	AccountLoginPage accountLoginPage;
	MyAccountPage myAccountPage;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		softAssert = new SoftAssert();
		yourStorePage = new YourStorePage(driver.get(), true).get();
		AccountLoginPage accountLoginPage = yourStorePage.clickLoginBtn();
		myAccountPage = accountLoginPage.login("Nav12@icloud.com", "Navjot13");

	}

	@Test
	public void verifyUserIsAbleToLogout() {
		AccountLogoutPage accountLogoutPage = myAccountPage.clicklogoutBtn();
		softAssert.assertEquals(accountLogoutPage.getAccountLogoutText(), "Account Logout", "Logout failed");
		accountLogoutPage.clickContinueBtn();
		softAssert.assertEquals(driver.get().getTitle(), "Your Store", "Logout failed");
		softAssert.assertAll();

	}

	@AfterMethod
	public void tearDown() {
		quitBrowser();
	}
}

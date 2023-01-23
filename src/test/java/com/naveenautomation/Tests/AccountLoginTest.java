package com.naveenautomation.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Pages.AccountLoginPage;
import com.naveenautomation.Pages.YourStorePage;

public class AccountLoginTest extends TestBase {
	YourStorePage yourStorePage;
	AccountLoginPage accountLoginPage;
	SoftAssert softAssert;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		yourStorePage = new YourStorePage(driver.get(), true).get();
		softAssert = new SoftAssert();
	}

	@Test
	public void verifyLogin() {
		accountLoginPage = yourStorePage.clickLoginBtn();
		accountLoginPage.login("Nav12@icloud.com", "Navjot13");
		softAssert.assertEquals(driver.get().getTitle(), "My Account", "Login failed");
	}

	@AfterMethod
	public void tearDown() {
		quitBrowser();
	}

}

package com.naveenautomation.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Pages.AccountCreatedPage;
import com.naveenautomation.Pages.RegisterAccountPage;
import com.naveenautomation.Pages.YourStorePage;

public class AccountCreatedTest extends TestBase {
	SoftAssert softAssert;
	YourStorePage yourStorePage;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		yourStorePage = new YourStorePage(driver.get(), true).get();
		softAssert = new SoftAssert();
	}

	@Test
	public void verifyUserIsAbleToSignUpSuccesfully() {
		RegisterAccountPage registerAccountPage = yourStorePage.clickRegisterBtn();
		AccountCreatedPage accountCreatedPage = registerAccountPage.signUp("Navjot", "Singh", "Nav16@icloud.com",
				"4372176789", "Navjot13", "Navjot13");
		softAssert.assertEquals(accountCreatedPage.getSuccessAccountCreatedText(), "Your Account Has Been Created!",
				"Sign up failed");
		softAssert.assertAll();
	}

	@AfterMethod
	public void tearDown() {
		quitBrowser();
	}
}

package com.naveenautomation.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Pages.AccountLoginPage;
import com.naveenautomation.Pages.MyAccountPage;
import com.naveenautomation.Pages.NewsletterSubscriptionPage;
import com.naveenautomation.Pages.YourStorePage;

public class MyAccountTest extends TestBase {

	SoftAssert softAssert;
	YourStorePage yourStorePage;
	AccountLoginPage accountLoginPage;
	MyAccountPage myAccountPage;
	NewsletterSubscriptionPage newsletterSubscriptionPage;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		softAssert = new SoftAssert();
		yourStorePage = new YourStorePage(driver.get(), true).get();
		AccountLoginPage accountLoginPage = yourStorePage.clickLoginBtn();
		myAccountPage = accountLoginPage.login("Nav12@icloud.com", "Navjot13");

	}

	@Test
	public void verifyUserIsAbleToUpdatePhoneNumber() {
		myAccountPage.clickEditInfo();
		myAccountPage.updateTelephone("4372176677");
		myAccountPage = myAccountPage.clickConitnueBtn();
		softAssert.assertEquals(driver.get().getTitle(), "My Account", "Account phone number updation failed");
		softAssert.assertEquals(myAccountPage.getAccountUpadteSuccessfulText(),
				"Success: Your account has been successfully updated.", "Account phone number updation failed");
		softAssert.assertAll();

	}

	@Test
	public void verifyUserIsAbleToSubscribeNewsLetter() {
		newsletterSubscriptionPage = myAccountPage.clickSubscribeNewsletter();
		newsletterSubscriptionPage.clickSubscribe();
		myAccountPage = newsletterSubscriptionPage.clickContinueBtn();
		softAssert.assertEquals(driver.get().getTitle(), "My Account", "Newsletter Subscription failed");
		softAssert.assertEquals(myAccountPage.getAccountUpadteSuccessfulText(),
				"Success: Your newsletter subscription has been successfully updated!",
				"Newsletter Subscription failed");
		softAssert.assertAll();

	}

	@AfterMethod
	public void tearDown() {
		quitBrowser();
	}
}

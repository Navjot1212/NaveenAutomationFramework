package com.naveenautomation.Tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Pages.AccountLoginPage;
import com.naveenautomation.Pages.MyAccountPage;
import com.naveenautomation.Pages.OrderHistoryPage;
import com.naveenautomation.Pages.OrderHistoryPage.OrderHistory;

public class OrderHistoryTest extends TestBase {
	
	SoftAssert softAssert;


	@BeforeMethod
	public void setUp() {
		launchBrowser();
		softAssert = new SoftAssert();
	}

	@Test
	public void verifyPriceForOrder() {
		AccountLoginPage accountLoginPage = new AccountLoginPage(driver.get(), true).get();
		MyAccountPage myAccountPage = accountLoginPage.login("iron.man@gmail.com", "Password2");
		OrderHistoryPage orderHistoryPage = myAccountPage.clickOrderHistory();
		WebElement priceElement = orderHistoryPage.getElementFromTheTable("#2539", OrderHistory.CUSTOMER);
		softAssert.assertEquals(priceElement.getText(), "priceElement.getText()");
	}

	@AfterMethod
	public void teardown() {
		quitBrowser();
	}
}
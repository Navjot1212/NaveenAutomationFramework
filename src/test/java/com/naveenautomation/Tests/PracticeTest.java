package com.naveenautomation.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Pages.YourStorePage;

public class PracticeTest extends TestBase {

	YourStorePage yourStorePage;

	@BeforeMethod
	public void setUp() {
		launchBrowser();

	}

	@Test
	public void verify1() {
		yourStorePage = new YourStorePage(driver.get(), true).get();

	}

	@Test
	public void verify2() {
// Jenkins Webhook
	}

	@Test
	public void verify3() {

	}

	@Test
	public void verify4() {

	}

	@Test
	public void verify5() {

	}

	@Test
	public void verify6() {

	}

	@Test
	public void verify7() {

	}

	@Test
	public void verify8() {

	}

	@Test
	public void verify9() {

	}

	@Test
	public void verify10() {

	}

	@AfterMethod
	public void tearDown() {
		quitBrowser();
	}
}

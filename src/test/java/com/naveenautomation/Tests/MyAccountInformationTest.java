package com.naveenautomation.Tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Pages.AccountLoginPage;
import com.naveenautomation.Pages.MyAccountInformationPage;
import com.naveenautomation.Pages.MyAccountPage;
import com.naveenautomation.Pages.YourStorePage;
import com.naveenautomation.Utils.ExcelUtils;

public class MyAccountInformationTest extends TestBase {

	SoftAssert softAssert;
	YourStorePage yourStorePage;
	AccountLoginPage accountLoginPage;
	MyAccountPage myAccountPage;
	MyAccountInformationPage myAccountInformationPage;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		softAssert = new SoftAssert();
		yourStorePage = new YourStorePage(driver.get(), true).get();
		accountLoginPage = yourStorePage.clickLoginBtn();
	}

	@Test(dataProvider = "LoginDataProvider")
	public void verifyAccountInfoIsPreFilledOnTheEdiAccountInfoPageForAllUsers(String username, String password,
			String firstName, String lastName, String email, String telephone) {
		myAccountPage = accountLoginPage.login(username, password);
		softAssert.assertEquals(driver.get().getTitle(), "My Account", "Page title did not matched");
		myAccountInformationPage = myAccountPage.clickEditInfo();
		softAssert.assertEquals(myAccountInformationPage.getFirstName(), firstName, "First name did not matched");
		softAssert.assertEquals(myAccountInformationPage.getLastName(), lastName, "Last name did not matched");
		softAssert.assertEquals(myAccountInformationPage.getEmail(), email, "Email did not matched");
		softAssert.assertEquals(myAccountInformationPage.getTelephone(), telephone, "Telephone did not matched");
		softAssert.assertAll();

	}

	@DataProvider(name = "LoginDataProvider")
	public Object[][] provideLoginData() throws IOException {
		String filePath = "./Test Data\\LoginDetails.xlsx";
		int rowCount = ExcelUtils.getRowCount(filePath, "Sheet1");
		int colCount = ExcelUtils.getColumnCount(filePath, "Sheet1", rowCount);
		String[][] loginData = new String[rowCount][colCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				loginData[i - 1][j] = ExcelUtils.getCellValue(filePath, "Sheet1", i, j);
			}
		}
		return loginData;
	}

	@AfterMethod
	public void tearDown() {
		quitBrowser();
	}

}

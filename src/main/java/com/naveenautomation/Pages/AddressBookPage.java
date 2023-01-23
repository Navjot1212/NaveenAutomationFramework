package com.naveenautomation.Pages;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.naveenautomation.Browsers.ProxyDriver;

public class AddressBookPage extends Page {

	public AddressBookPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final String PAGE_URL = "/address";
	Scanner sc = new Scanner(System.in);
	private static final By sucessAlert = By.cssSelector("div.alert");
	private static final By firstName = By.id("input-firstname");
	private static final By lastName = By.id("input-lastname");
	private static final By address = By.id("input-address-1");
	private static final By city = By.id("input-city");
	private static final By postalCode = By.id("input-postcode");
	private static final By country = By.id("input-country");
	private static final By province = By.id("input-zone");
	private static final By continueBtn = By.cssSelector("input[value='Continue']");

	public String getSucessAlert() {
		return ((ProxyDriver) wd).getText(sucessAlert, 10);
	}

	public String getAddress(String customerName, String postalCode) {
		return getElementFromTheTable(customerName, postalCode, AddressBookEntries.ADDRESS).getText();

	}

	public void editAddress(String customerName, String postalcode) {
		getElementFromTheTable(customerName, postalcode, AddressBookEntries.EDIT).click();
		System.out.println("Please enter first name");
		((ProxyDriver) wd).clear(firstName);
		((ProxyDriver) wd).sendKeys(firstName, sc.nextLine());
		System.out.println("Please enter last name");
		((ProxyDriver) wd).clear(lastName);
		((ProxyDriver) wd).sendKeys(lastName, sc.nextLine());
		System.out.println("Please enter Address");
		((ProxyDriver) wd).clear(address);
		((ProxyDriver) wd).sendKeys(address, sc.nextLine());
		System.out.println("Please enter City");
		((ProxyDriver) wd).clear(city);
		((ProxyDriver) wd).sendKeys(city, sc.nextLine());
		System.out.println("Please enter postal code");
		((ProxyDriver) wd).clear(postalCode);
		((ProxyDriver) wd).sendKeys(postalCode, sc.nextLine());
		System.out.println("Please enter Country");
		String country = sc.nextLine();
		((ProxyDriver) wd).selectFromDropDown(AddressBookPage.country, country);
		System.out.println("Please enter Region/State");
		String province = sc.nextLine();
		((ProxyDriver) wd).selectFromDropDown(AddressBookPage.province, province);
		((ProxyDriver) wd).click(continueBtn);

	}

	public void deleteAddress(String customerName, String postalCode) {
		getElementFromTheTable(customerName, postalCode, AddressBookEntries.DELETE).click();
		wd.switchTo().alert().accept();

	}

	public WebElement getElementFromTheTable(String customerName, String postalCode, AddressBookEntries column) {
		List<WebElement> rowsInTable = wd.findElements(By.cssSelector("table.table tbody tr"));
		for (WebElement row : rowsInTable) {
			List<WebElement> cellsInARow = row.findElements(By.cssSelector("td"));
			String addressText = cellsInARow.get(0).getText();
			if (addressText.contains(customerName) && addressText.contains(postalCode)) {
				switch (column) {
				case ADDRESS:
					return cellsInARow.get(0);
				case EDIT:
					return cellsInARow.get(1).findElement(By.cssSelector("a:first-of-type"));
				case DELETE:
					return cellsInARow.get(1).findElement(By.cssSelector("a:last-of-type"));
				default:
					System.out.println("Column not found!!!");
					break;
				}
			}
		}
		System.out.println("Address not found!!!");
		return null;
	}

	public enum AddressBookEntries {
		ADDRESS, EDIT, DELETE;
	}

	@Override
	protected void isLoaded() {

		if (!urlContains(wd.getCurrentUrl())) {
			throw new Error();
		}
	}

	@Override
	protected String getPageUrl() {
		return getDomain() + PAGE_URL;
	}

	@Override
	public AddressBookPage get() {
		return (AddressBookPage) super.get();
	}
}

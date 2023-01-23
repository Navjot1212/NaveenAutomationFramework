package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.Browsers.ProxyDriver;

public class MyAccountInformationPage extends Page {

	public MyAccountInformationPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final String PAGE_URL = "/edit";
	private static final By firstName = By.id("input-firstname");
	private static final By lastName = By.id("input-lastname");
	private static final By email = By.id("input-email");
	private static final By telephone = By.id("input-telephone");

	public String getFirstName() {
		return ((ProxyDriver) wd).findElement(firstName).getAttribute("value");
	}

	public String getLastName() {
		return ((ProxyDriver) wd).findElement(lastName).getAttribute("value");

	}

	public String getEmail() {
		return ((ProxyDriver) wd).findElement(email).getAttribute("value");

	}

	public String getTelephone() {
		return ((ProxyDriver) wd).findElement(telephone).getAttribute("value");

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
	public MyAccountInformationPage get() {
		return (MyAccountInformationPage) super.get();
	}

}

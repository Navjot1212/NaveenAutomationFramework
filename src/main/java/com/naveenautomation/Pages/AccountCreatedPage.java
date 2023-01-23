package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.naveenautomation.Browsers.ProxyDriver;

public class AccountCreatedPage extends Page {

	public AccountCreatedPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final String PAGE_URL = "/success";
	private static final By accountCreationSuccessText = By.cssSelector("#content h1");

	public String getSuccessAccountCreatedText() {
		return ((ProxyDriver) wd).getText(accountCreationSuccessText, 10);
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
	public AccountCreatedPage get() {
		return (AccountCreatedPage) super.get();
	}
}

package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.Browsers.ProxyDriver;

public class AccountLogoutPage extends Page {

	public AccountLogoutPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final String PAGE_URL = "/logout";
	private static final By accountLogoutText = By.cssSelector("#content h1");
	private static final By continueBtn = By.cssSelector("a.btn");

	public String getAccountLogoutText() {
		return ((ProxyDriver) wd).getText(accountLogoutText, 10);
	}

	public YourStorePage clickContinueBtn() {
		((ProxyDriver) wd).click(continueBtn);
		return new YourStorePage(wd, true);
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
	public AccountLogoutPage get() {
		return (AccountLogoutPage) super.get();
	}
}

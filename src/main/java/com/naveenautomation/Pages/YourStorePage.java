package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.Browsers.ProxyDriver;

public class YourStorePage extends Page {

	public YourStorePage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final String PAGE_URL = "/home";

	private static final By myAccountDropDownMenu = By.cssSelector("a[title='My Account']");

	private static final By register = By.cssSelector("a[href$=register]");

	private static final By login = By.cssSelector("li>ul a[href$=login]");

	public RegisterAccountPage clickRegisterBtn() {
		((ProxyDriver) wd).click(myAccountDropDownMenu);
		((ProxyDriver) wd).click(register);
		return new RegisterAccountPage(wd, true);
	}

	public AccountLoginPage clickLoginBtn() {
		((ProxyDriver) wd).click(myAccountDropDownMenu);
		((ProxyDriver) wd).click(login);
		return new AccountLoginPage(wd, true);
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
	public YourStorePage get() {
 		return (YourStorePage) super.get();
	}
}

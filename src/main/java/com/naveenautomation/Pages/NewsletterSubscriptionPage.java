package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.Browsers.ProxyDriver;

public class NewsletterSubscriptionPage extends Page {

	public NewsletterSubscriptionPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final String PAGE_URL = "/newsletter";

	private static final By noRadioBtn = By.cssSelector("input[value='0']");
	private static final By yesRadioBtn = By.cssSelector("input[value='1']");
	private static final By continueBtn = By.cssSelector("input[value='Continue']");

	public void clickSubscribe() {
		((ProxyDriver) wd).click(yesRadioBtn);
	}

	public void clickUnsubscribe() {
		((ProxyDriver) wd).click(noRadioBtn);

	}

	public MyAccountPage clickContinueBtn() {
		((ProxyDriver) wd).click(continueBtn);
		return new MyAccountPage(wd, true);
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
	public NewsletterSubscriptionPage get() {
		return (NewsletterSubscriptionPage) super.get();
	}
}

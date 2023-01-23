package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.naveenautomation.Browsers.ProxyDriver;

public class MyAccountPage extends Page {

	public MyAccountPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final String PAGE_URL = "/account";
	private static final By laptopsMenu = By.xpath("//a[text()='Laptops & Notebooks']");
	private static final By allLaptopsOptionBtn = By.xpath("//a[text()='Show All Laptops & Notebooks']");
	private static final By addressBook = By.cssSelector("div>a[href$='address']");
	private static final By editInformation = By.cssSelector("li>a[href$='edit']");
	private static final By telephone = By.cssSelector("input-telephone");
	private static final By continueBtn = By.cssSelector("input[value='Continue']");
	private static final By accountUpadteSuccessfulText = By.cssSelector("div.alert");
	private static final By subscribeNewsletter = By.xpath("//a[text()='Subscribe / unsubscribe to newsletter']");
	private static final By orderHistory = By.cssSelector("div>a[href$=order]");
	private static final By logoutBtn = By.cssSelector("div.list-group a:last-of-type");

	public OrderHistoryPage clickOrderHistory() {
		((ProxyDriver) wd).click(orderHistory);
		return new OrderHistoryPage(wd, true);
	}

	public MyAccountInformationPage clickEditInfo() {
		((ProxyDriver) wd).click(editInformation);
		return new MyAccountInformationPage(wd, true);
	}

	public LaptopsAndNotebooksPage clickAllLaptopsAndNoteBooksBtn() {
		((ProxyDriver) wd).click(laptopsMenu);
		((ProxyDriver) wd).click(allLaptopsOptionBtn);
		return new LaptopsAndNotebooksPage(wd, true);
	}

	public AddressBookPage clickAddressBookBtn() {
		((ProxyDriver) wd).click(addressBook);
		return new AddressBookPage(wd, true);
	}

	public void updateTelephone(String phone) {
		((ProxyDriver) wd).clear(telephone);
		((ProxyDriver) wd).sendKeys(telephone, phone);

	}

	public MyAccountPage clickConitnueBtn() {
		((ProxyDriver) wd).click(continueBtn);
		return new MyAccountPage(wd, true);
	}

	public String getAccountUpadteSuccessfulText() {
		return ((ProxyDriver) wd).getText(accountUpadteSuccessfulText, 10);
	}

	public NewsletterSubscriptionPage clickSubscribeNewsletter() {
		((ProxyDriver) wd).click(subscribeNewsletter);
		return new NewsletterSubscriptionPage(wd, true);
	}

	public AccountLogoutPage clicklogoutBtn() {
		((ProxyDriver) wd).click(logoutBtn);
		return new AccountLogoutPage(wd, true);
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
	public MyAccountPage get() {
		return (MyAccountPage) super.get();
	}

}

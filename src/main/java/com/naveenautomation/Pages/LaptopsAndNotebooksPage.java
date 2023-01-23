package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.Browsers.ProxyDriver;
import com.naveenautomation.Utils.Utils;

public class LaptopsAndNotebooksPage extends Page {

	public LaptopsAndNotebooksPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final String PAGE_URL = "/category&path=18";
	private static final By pageHeadingText = By.cssSelector("#content h2");
	private static final By sortingList = By.id("input-sort");
	private static final By firstProductWishListBtn = By
			.cssSelector("#content>div:nth-of-type(4)>div:first-of-type button:nth-of-type(2)");
	private static final By secondProductWishListBtn = By
			.cssSelector("#content>div:nth-of-type(4)>div:nth-of-type(2) button:nth-of-type(2)");
	private static final By thirdProductWishListBtn = By
			.cssSelector("#content>div:nth-of-type(4)>div:nth-of-type(3) button:nth-of-type(2)");
	private static final By wishlistAddedSuccessText = By.cssSelector("div.alert");
	private static final By wishlistBtn = By.cssSelector("div.alert a:last-of-type");

	public String getPageHeadingText() {
		return ((ProxyDriver) wd).getText(pageHeadingText, 10);
	}

	public void sortProductsByHighestRating() {
		((ProxyDriver) wd).selectFromDropDown(sortingList, "Rating (Highest)");
	}

	private void addFirstProductToWishList() {
		((ProxyDriver) wd).click(firstProductWishListBtn);
	}

	private void addSecondProductToWishList() {
		((ProxyDriver) wd).click(secondProductWishListBtn);
	}

	private void addThirdProductToWishList() {
		((ProxyDriver) wd).click(thirdProductWishListBtn);

	}

	public void addProductsToWishList() {
		addFirstProductToWishList();
		addSecondProductToWishList();
		addThirdProductToWishList();
		Utils.sleep(1500);
	}

	public String getWishlistAddedSuccessText() {
		return ((ProxyDriver) wd).getText(wishlistAddedSuccessText, 0);
	}

	public MyWishListPage clickWishList() {
		((ProxyDriver) wd).click(wishlistBtn);
		return new MyWishListPage(wd, true);
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
	public LaptopsAndNotebooksPage get() {
		return (LaptopsAndNotebooksPage) super.get();
	}
}

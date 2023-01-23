package com.naveenautomation.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.naveenautomation.Browsers.ProxyDriver;

public class MyWishListPage extends Page {

	public MyWishListPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final String PAGE_URL = "/wishlist";
	private static final By successAlert = By.cssSelector("div.alert");

	public String getSuccessAlertText() {
		return ((ProxyDriver) wd).getText(successAlert, 10);
	}

	public void removeProduct(String productName, MyWishList column, By locator) {
		getElementFromTheTable(productName, column).findElement(locator).click();
	}

	public WebElement getElementFromTheTable(String ProductName, MyWishList column) {
		int columnIndex = getIndexForColumn(column);
		List<WebElement> rowsInTable = wd.findElements(By.cssSelector("table.table>tbody>tr"));
		for (WebElement row : rowsInTable) {
			List<WebElement> cellsInARow = row.findElements(By.cssSelector("td"));
			String ProductNameText = cellsInARow.get(1).getText();
			if (ProductNameText.equals(ProductName)) {
				return cellsInARow.get(columnIndex);
			}
		}
		System.out.println("Column name was not found!!!");
		return null;
	}

	private int getIndexForColumn(MyWishList column) {
		List<WebElement> tableHeaders = wd.findElements(By.cssSelector("table.table>thead>tr>td"));
		for (WebElement header : tableHeaders) {
			if (header.getText().equals(column.getName())) {
				return tableHeaders.indexOf(header);
			}
		}
		System.out.println("No such column exist");
		return -1;
	}

	public enum MyWishList {
		IMAGE("Image"), PRODUCTNAME("Product Name"), MODEL("Model"), STOCK("Stock"), UNITPRICE("Unit Price"),
		ACTION("Action");

		String name;

		private MyWishList(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

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
	public MyWishListPage get() {
		return (MyWishListPage) super.get();
	}
}

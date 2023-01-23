package com.naveenautomation.Base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.naveenautomation.Browsers.Browsers;
import com.naveenautomation.Browsers.ProxyDriver;
import com.naveenautomation.Listeners.WebdriverEvents;

public class TestBase {

	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	DesiredCapabilities capabilities = new DesiredCapabilities();
	public static WebdriverEvents events;
	public EventFiringWebDriver eventFiringWebDriver;
	Browsers DEFAULT_BROWSER = Browsers.GOOGLE_CHROME;

	public void launchBrowser() {
		switch (DEFAULT_BROWSER) {
		case GOOGLE_CHROME:
			capabilities.setBrowserName("chrome");
			capabilities.setPlatform(Platform.WINDOWS);
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.merge(capabilities);
			try {
				driver.set(new ProxyDriver(new RemoteWebDriver(new URL("http://10.0.0.69:4444"), chromeOptions)));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			break;
		case EDGE:
			capabilities.setBrowserName("edge");
			capabilities.setPlatform(Platform.WINDOWS);
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.merge(capabilities);
			try {
				driver.set(new ProxyDriver(new RemoteWebDriver(new URL("http://10.0.0.69:4444"), edgeOptions)));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			break;
		case FIREFOX:
			capabilities.setBrowserName("firefox");
			capabilities.setPlatform(Platform.WINDOWS);
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.merge(capabilities);
			try {
				driver.set(new ProxyDriver(new RemoteWebDriver(new URL("http://10.0.0.69:4444"), firefoxOptions)));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			break;

		default:
			System.out.println("Not a valid browser");
			break;
		}
		eventFiringWebDriver = new EventFiringWebDriver(driver.get());
		events = new WebdriverEvents();
		eventFiringWebDriver.register(events);
		driver.set(new ProxyDriver(eventFiringWebDriver));
		driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get().manage().window().maximize();
		driver.get().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get().manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
	}

	public void quitBrowser() {
		driver.get().close();
	}
}

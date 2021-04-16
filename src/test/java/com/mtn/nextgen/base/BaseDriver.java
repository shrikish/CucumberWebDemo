package com.mtn.nextgen.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseDriver {
	
	protected WebDriver driver;
	protected AndroidDriver<AndroidElement> androidDriver;
	private AppiumDriverLocalService service;

	public BaseDriver(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebDriver getWebDriver() {
		if(driver == null) {
			String dr = "Chrome";
			switch(dr.toLowerCase()) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver","C:\\Users\\shrik\\eclipse-workspace\\plugins\\chromedriver.exe");
				driver = new ChromeDriver();
				break;
			case "firefox":
				System.setProperty("webdriver.gecko.driver","C:\\Users\\shrik\\eclipse-workspace\\plugins\\chromedriver.exe");
				driver = new FirefoxDriver();
				break;
			case "safari":
				driver = new SafariDriver();
				break;
			default:
				System.out.println("Driver not defined");
				break;
			}
			driver.manage().window().maximize();
			return driver;
		}
		else
			return driver;
	}

	protected AndroidDriver<WebElement> _getAndroidDriver() {
		return null;

	}

	protected void preparation()  {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "10");
		capabilities.setCapability("deviceName", "25e2e78c130d7ece");
		capabilities.setCapability("appPackage", "com.appium");
		capabilities.setCapability("appActivity", "com.appium.MainActivity");
		service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		String service_url = service.getUrl().toString();
		System.out.println("Appium Service Address: " + service_url);
		try {
			androidDriver = new AndroidDriver<>(new URL(service_url), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public void stopServer() {
		service.stop();
	}
}

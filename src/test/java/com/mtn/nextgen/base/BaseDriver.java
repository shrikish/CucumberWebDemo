package com.mtn.nextgen.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseDriver {
	
	protected WebDriver driver;

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
}

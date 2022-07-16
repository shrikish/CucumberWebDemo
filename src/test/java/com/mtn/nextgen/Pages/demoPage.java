package com.mtn.nextgen.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mtn.nextgen.base.BaseDriver;

public class demoPage extends BaseDriver{
	
	@FindBy(partialLinkText = "Read More")
	private WebElement eleReadMore;
	
	@FindBy(partialLinkText = "Contact")
	private WebElement eleContact;
	
	public demoPage(WebDriver driver) {
		super(driver);
	}
	
	
	public void gotoMTN() {
		driver.get("https://www.mtn.com/");
	}
	
	public void clickonValue() {
		eleReadMore.click();
	}
	
	public void clickonValue2() {
		eleContact.click();
	}
}

package com.mtn.nextgen.StepDefinition;

import org.openqa.selenium.WebDriver;

import com.mtn.nextgen.Pages.demoPage;
import com.mtn.nextgen.base.BaseDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DemoSteps{

	WebDriver driver;
	demoPage dp;
	
	@Before
	public void init() {
		BaseDriver dr = new BaseDriver(driver);
		driver = dr.getWebDriver();
	}
	
	@Given("I want launch browser")
	public void i_want_launch_browser() {
		dp = new demoPage(driver);
	}

	@When("I go to google")
	public void i_go_to_google() {
		dp.gotoMTN();
	}

	@Then("I search value")
	public void i_search_value() {
		dp.clickonValue();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Then("I search value2")
	public void i_search_value2() {
		dp.clickonValue2();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}

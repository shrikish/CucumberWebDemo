package com.mtn.nextgen.base;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/FeatureFiles",
		glue={"com.mtn.nextgen.StepDefinition"},
		plugin={"pretty", "html:target/cucumber-report/cucumber.html",
					"json:target/cucumber-report/cucumber.json",
					"junit:target/cucumber-report/cucumber.xml",
					"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
//		,monochrome=true
//		,dryRun=false
		)
public class RunCucumberTest {

}

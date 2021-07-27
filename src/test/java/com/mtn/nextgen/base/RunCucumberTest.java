package com.mtn.nextgen.base;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/FeatureFiles",
		glue={"com.mtn.nextgen.StepDefinition"},
		plugin={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
//		,monochrome=true
//		,dryRun=false
		)
public class RunCucumberTest {

}

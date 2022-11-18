package com.qa.auto.modules;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Runner class 
 * @author Prince Khanna
 *
 */

@CucumberOptions(dryRun = false, monochrome = true, glue = { "" }, features = { "src\\test\\java\\features" },
		plugin = { "pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })
public class TestRunner extends AbstractTestNGCucumberTests {


}

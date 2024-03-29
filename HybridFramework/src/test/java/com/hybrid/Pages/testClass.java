package com.hybrid.Pages;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.beust.jcommander.Parameter;
import com.hybrid.Utilities.BrowserFactory;
import com.hybrid.Utilities.ConfigDataProviders;
import com.hybrid.Utilities.ExcelDataProviders;
import com.hybrid.Utilities.helper;

public class testClass {

	public WebDriver driver;
	public ExcelDataProviders excelreader;
	public ConfigDataProviders config;
	public ExtentReports extentreport;
	public ExtentTest logger;

	//This is a setup suit which initialize to Browser ans launch the application URl before Suit
	
	@Parameters({"appUrl","browser"})
	@BeforeClass
	public void setup(String appUrl, String browser) {
		Reporter.log("Browser initiated", true);
		//driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.geturl());
		
		driver = BrowserFactory.startApplication(driver, browser, appUrl);
		Reporter.log("Browser initiated", true);
	}

	@AfterClass
	public void teardown() {
		Reporter.log("Browser Closed", true);
		BrowserFactory.quitbrowser(driver);
	}

	@AfterMethod
	public void teardownMethod(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.SUCCESS) {

			logger.pass("Test PASSED",
					MediaEntityBuilder.createScreenCaptureFromPath(helper.captureScreenshots(driver)).build());

		}
		
		else if (result.getStatus() == ITestResult.FAILURE) {

			logger.fail("Test Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(helper.captureScreenshots(driver)).build());

		}
		
		else if (result.getStatus() == ITestResult.SKIP) {

			logger.skip("Test SKIPPED",
					MediaEntityBuilder.createScreenCaptureFromPath(helper.captureScreenshots(driver)).build());

		}
		Reporter.log("Screenshot taken and attached to the report", true);
		extentreport.flush();

	}

}

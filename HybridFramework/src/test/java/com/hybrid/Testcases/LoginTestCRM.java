package com.hybrid.Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.hybrid.Pages.BaseClass;
import com.hybrid.Pages.LoginPage;
import com.hybrid.Utilities.BrowserFactory;
import com.hybrid.Utilities.ExcelDataProviders;
import com.hybrid.Utilities.helper;

public class LoginTestCRM extends BaseClass {

	@Test(priority = 1)
	public void LoginApp() {
		logger = extentreport.createTest("Login to Application");

		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		logger.info("Starting the Application");

		loginpage.Login(excelreader.getStringData("Sheet1", 1, 0), excelreader.getStringData("Sheet1", 1, 1));

		logger.pass("Login success");

	}

}

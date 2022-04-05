package com.hybrid.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(id = "loginusername")
	WebElement uname;
	@FindBy(id = "loginpassword")
	WebElement pwrd;
	@FindBy(xpath = "//div/button[@onclick='logIn()']")
	WebElement loginBtn;
	@FindBy(id = "login2")
	WebElement loginLink;
	
	@FindBy(xpath="//*[@id='nameofuser']")
	WebElement loggedInuser;

	public void Login(String username, String password) {

		if (loginLink.isDisplayed()) {
			loginLink.click();
		} else {
			Reporter.log("Unable to click on Link", true);
		}

		uname.sendKeys(username);
		pwrd.sendKeys(password);

		if (loginBtn.isDisplayed()) {
			// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			loginBtn.click();
			System.out.println("login button clicked");

		} else {
			System.out.println("Login button not displayed");
		}
		
		if (loggedInuser.getText().contains("Ashish dhaundi")) {
			Reporter.log("User loggedin successfully", true);
		}
		else {
			Reporter.log("user login failed");
		}
	}
}

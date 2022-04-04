package com.hybrid.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	@FindBy(name="username") WebElement uname;
	@FindBy(name="password") WebElement pwrd;
	@FindBy(xpath="//input[@type='submit']") WebElement loginBtn;
	
	public void Login(String username, String password) {
		
		uname.sendKeys(username);
		pwrd.sendKeys(password);
		loginBtn.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}

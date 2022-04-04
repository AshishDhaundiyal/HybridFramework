package com.hybrid.Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {

//WebDriver driver;

	public static WebDriver startApplication(WebDriver driver, String browser,String Url) {
		
		if (browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver1.exe");
			driver = new ChromeDriver();

		} else if (browser.equals("Firefox")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver1.exe");
			driver = new ChromeDriver();
		}

		else {
			System.out.println("Cannot open the browser");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}

	public static void quitbrowser(WebDriver driver) {
		driver.quit();
	}
}

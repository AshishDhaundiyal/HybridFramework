package com.hybrid.Utilities;

import java.io.File;
import java.util.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class helper {

	// to handle the screenshot , frames, windows, sync issues, JS executers

	public static String captureScreenshots(WebDriver driver) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath = System.getProperty("user.dir"+"/Screenshots/"+getCurrentDateTime() +" Login.png");
		
		try {
			FileHandler.copy(src, new File("./Screenshots/"+getCurrentDateTime() +" Login.png"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Cannot take screenshot" + e.getMessage());

		}

		return screenshotPath;
	}
	
	public static String getCurrentDateTime() {
		
		DateFormat customFormat= new SimpleDateFormat("MM_dd_yy_HH_mm");
		Date currentdate = new Date();
		return customFormat.format(currentdate);
	}

}

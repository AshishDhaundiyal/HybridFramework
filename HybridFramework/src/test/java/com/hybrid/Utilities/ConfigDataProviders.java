package com.hybrid.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProviders {

	Properties pro;

	public ConfigDataProviders() {

		File src = new File("./Config/Config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro= new Properties();
			pro.load(fis);
		} catch (Exception e) {

			System.out.println("Unable to load config file" + e.getMessage());
		}

	}

	public String getBrowser() {
		System.out.println(pro.getProperty("Browser"));
		return pro.getProperty("Browser");
		

	}

	public String geturl() {
System.out.println(pro.getProperty("URL"));
		
		return pro.getProperty("URL");

	}

	public String getValuefromConfig(String keyValue) {

		return pro.getProperty(keyValue);

	}

}

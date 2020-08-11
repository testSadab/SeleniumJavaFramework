package com.autoprac.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	static Properties pro;
	
	public ConfigReader() {
		try {
			pro = new Properties();
			FileInputStream fis = new FileInputStream("C://Eclips_projects/SeleniumJavaFramework/src/main/java/com/autoprac/config/config.properties");
			pro.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	//Method to read property
	public String getBrowserName() {
		return pro.getProperty("browser");
	}
	
	public String getUrl() {
		return pro.getProperty("url");
	}
	
	public String getPageLoadTimeout() {
		return pro.getProperty("pageloadtimeout");
	}
	
	public String getImplicitTimeout() {
		return pro.getProperty("implicittimeout");
	}
	
}

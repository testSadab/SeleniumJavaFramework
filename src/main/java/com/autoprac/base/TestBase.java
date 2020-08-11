package com.autoprac.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.autoprac.utilities.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;	
	public static ConfigReader conf;
	
	public TestBase() {
		conf = new ConfigReader();
	}
	
	public static void init() {
		String browserName = conf.getBrowserName();
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		else{
			System.out.println("Please specify browser in config file....");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(conf.getPageLoadTimeout()), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(conf.getImplicitTimeout()), TimeUnit.SECONDS);
		
		driver.get(conf.getUrl());
	}

}

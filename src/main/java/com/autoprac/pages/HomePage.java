package com.autoprac.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.autoprac.base.TestBase;

public class HomePage extends TestBase {
	//Locators
	By homepage_logo = By.id("header_logo");
	By allMenu = By.cssSelector("#block_top_menu>ul>li>a");
	
	//Getters and Setters
	public HomePage() {
		super();
	}
	
	
	public WebElement getHomePageLogo() {
		return driver.findElement(homepage_logo);
	}
	
	public List<WebElement> getAllMenu() {
		return driver.findElements(allMenu);
	}
	
	//Action Methods
	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateLogo() {
		return getHomePageLogo().isDisplayed();
	}
	
	public void printAllMenuText() {
		for (WebElement menuItem : getAllMenu()) {
			System.out.println("Menu Item: "+menuItem.getText());
		}
	}
	
	public WebElement getSpecificMenu(String menuName) {
		return driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li/a[text()='"+menuName+"']"));
	}
	
	public WebElement getSpecificSubMenu(String subMenuName) {
		return driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li/a[text()='Women']/..//a[text()='"+subMenuName+"']"));
	}

}

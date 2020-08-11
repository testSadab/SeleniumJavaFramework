package com.autoprac.testcases;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.autoprac.base.TestBase;
import com.autoprac.pages.HomePage;

public class HomeTest extends TestBase {

	private static HomePage hp;
	
	public HomeTest() {
		super();
	}

	
	@BeforeMethod
	public void setUp() {
		init();
		hp=new HomePage();
	}
	
	@Test(priority=1, enabled=false)
	public static void verifyHomePage() {		
		String homepage_title = hp.validatePageTitle();
		
		try {
			Assert.assertEquals("Title Didn't match", "My Store", homepage_title);
		} catch (Exception e) {
			Assert.fail();
		}
		
		try {
			Assert.assertTrue(hp.validateLogo());
		} catch (Exception e) {
			driver.close();
			Assert.fail();
		}
		
		hp.printAllMenuText();
		System.out.println("Test Executed Successfully..!!");
		
	}
	
	@Test(priority=2)
	public void naviagteToTshirt() throws InterruptedException {
//		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement menuItem = hp.getSpecificMenu("Women");
		System.out.println("Printing Menu: "+menuItem.getText());
		Actions act = new Actions(driver);
		act.moveToElement(menuItem).perform();
		driver.wait(3000);
		
		WebElement TshirtSubMenu = hp.getSpecificSubMenu("T-shirts");
		act.moveToElement(TshirtSubMenu).build().perform();
		driver.wait(3000);
		TshirtSubMenu.click();
		driver.wait(3000);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

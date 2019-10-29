package com.qa.rsautomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.rsautomation.base.TestBase;
import com.qa.rsautomation.pages.HomePage;

public class HomePageTest extends TestBase {
	public HomePage hp;

	public HomePageTest()

	{
		super();
	}

	@BeforeMethod()

	public void setUp() {
		initialisation();
		hp = new HomePage();
	}

	@Test(priority = 1)
	public void verifyhomepageTitleTest() {
		
		String PageTitle = hp.verifyhomepageTitle();
		Assert.assertEquals(PageTitle, "RS Components | Electronic and Electrical Components",
				"HomePage Title is not displayed");
	}

	@Test(priority = 2)
	public void verifyhomepageLogoTest() {
		
		boolean logo = hp.verifyhomepageLogo();
		Assert.assertEquals(logo, true, "Logo is not displayed");
	}
	
	@Test(priority = 3)
	public void verifyclickLoginTest() {
				
		hp.clickLoginLink();
	}
	@AfterMethod()

	public void tearDown() {
		driver.quit();
	}
}

package com.qa.rsautomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.rsautomation.base.TestBase;
import com.qa.rsautomation.pages.HomePage;
import com.qa.rsautomation.pages.LoginPage;

public class LoginPageTest extends TestBase{
	public HomePage hp;
	public LoginPage lp;
	
	public LoginPageTest(){
		super();
	}
	@BeforeMethod()

	public void setUp() {	
		initialisation();
		hp = new HomePage();
		lp = new LoginPage();
	}
	@Test(priority = 1)
	public void verifyloginpageheaderTest() {
		hp.clickLoginLink();
		String loginheader = lp.verifyloginpageheader();
		Assert.assertEquals(loginheader, "Login","Login Header is not displayed");
	}
	
	@Test(priority = 2)
	public void enterLoginDetailsTest(){
		hp.clickLoginLink();
		lp.enterLoginDetails(prop.getProperty("username"),prop.getProperty("password"));
		lp.clickLogout();
		
	}
	
		
	@AfterMethod()

	public void tearDown() {
		
		
		driver.quit();
	}
}

package com.qa.rsautomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.rsautomation.base.TestBase;
import com.qa.rsautomation.pages.HomePage;
import com.qa.rsautomation.pages.LoginPage;
import com.qa.rsautomation.pages.ProductSearchPage;

public class ProductSearchPageTest extends TestBase{
	public HomePage hp;
	public LoginPage lp;
	public ProductSearchPage pspage;
	
	public ProductSearchPageTest()
	{
		super();
	}

	@BeforeMethod()

	public void setUp() {
		initialisation();
		hp = new HomePage();
		lp = new LoginPage();
		pspage = new ProductSearchPage();
		hp.clickLoginLink();
		lp.enterLoginDetails(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	@Test(priority = 1)
	public void verifyloggeduserTest() {
		
		String user = pspage.verifyloggeduser();
		Assert.assertEquals(user, "Welcome Ram", "Logged Username is not displayed");
		
	}
	
	@Test(priority = 2)
	public void searchProductTest(){
		pspage.searchProduct(prop.getProperty("product"));
		
		
	
	}
	@Test(priority = 3)
	public void verifypartNumberTest(){
		pspage.searchProduct(prop.getProperty("product"));
		String pn = pspage.verifypartNumber();
		Assert.assertEquals(pn, "0035012", "Different product is displayed");
		
	}
	
	
	@AfterMethod()

	public void tearDown() {
		driver.quit();
	}
}

package com.qa.rsautomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.rsautomation.base.TestBase;
import com.qa.rsautomation.pages.BasketSummaryPage;
import com.qa.rsautomation.pages.HomePage;
import com.qa.rsautomation.pages.LoginPage;
import com.qa.rsautomation.pages.ProductSearchPage;

public class BasketSummaryPageTest extends TestBase{
	
	public HomePage hp;
	public LoginPage lp;
	public ProductSearchPage pspage;
	public BasketSummaryPage basketpage;
	
	public BasketSummaryPageTest()
	{
		super();
	}

	@BeforeMethod()

	public void setUp() {
		initialisation();
		hp = new HomePage();
		lp = new LoginPage();
		pspage = new ProductSearchPage();
		basketpage = new BasketSummaryPage();
		hp.clickLoginLink();
		lp.enterLoginDetails(prop.getProperty("username"),prop.getProperty("password"));

}
	
	@Test(priority = 1)
	public void verifyBasketTest() {
		
		
		pspage.searchProduct(prop.getProperty("product"));
		pspage.addProducts();
		String qty = basketpage.verifyBasket();
		Assert.assertEquals(qty, "1", "Basket quantity is not same");
		String price = basketpage.verifyproductPrice();
		Assert.assertEquals(price, "£2.91", "product price is not displayed");
		basketpage.removeProduct();
		
	}
	
	@AfterMethod()

	public void tearDown() {
		driver.quit();
	
}
}
package com.qa.rsautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.rsautomation.base.TestBase;

public class ProductSearchPage extends TestBase {

	@FindBy(xpath = "//div[@id='js-welcome']")
	WebElement loggeduser;

	@FindBy(id = "searchTerm")
	WebElement searchbox;

	@FindBy(id = "btnSearch")
	WebElement searchbutton;

	@FindBy(xpath = "/html[1]/body[1]/div[4]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[2]/span[2]/span[1]")
	WebElement partnumber;
	
	@FindBy(xpath = "//div[@class='priceQuantity']//input[@class='form-control']")
	WebElement units;
	
	@FindBy(xpath = "//button[@class='btn btn-primary-red btn-large btn-add-to-basket']")
	WebElement Addtobasket;
	
	@FindBy(xpath= "//span[contains(text(),'Added')]")
	WebElement Added;
	
	

	public ProductSearchPage() {

		PageFactory.initElements(driver, this);
	}

	public String verifyloggeduser() {

		WebElement logheader = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.elementToBeClickable(loggeduser));

		return logheader.getText();

	}

	public void searchProduct(String product) {
		searchbox.sendKeys(product);
		searchbutton.click();

	}

	public String verifypartNumber() {

		return partnumber.getText();

	}
	
	public boolean addProducts(){
		units.clear();
		units.sendKeys("1");
		Addtobasket.click();
		return Added.isDisplayed();
			
	}
	
	

}

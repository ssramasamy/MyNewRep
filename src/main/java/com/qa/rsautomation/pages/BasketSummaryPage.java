	package com.qa.rsautomation.pages;
	
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	
	import com.qa.rsautomation.base.TestBase;
	
	public class BasketSummaryPage extends TestBase {
	
		@FindBy(xpath = "//div[@id='js-basketQty']")
		WebElement basket;
	
		@FindBy(xpath = "//td[@class='orderValueCell']")
		WebElement productprice;
	
		@FindBy(xpath = "//td[@class='orderValueCell grandTotalCell']")
		WebElement totalprice;
	
		@FindBy(xpath = "//a[@id='confirmDeleteContinue']")
		WebElement Continue;
	
		@FindBy(linkText = "Remove")
		WebElement remove;
	
		public BasketSummaryPage() {
			PageFactory.initElements(driver, this);
		}
	
		public String verifyBasket() {
	
			basket.click();
			return basket.getText();
	
		}
	
		public String verifyproductPrice() {
	
			return productprice.getText();
	
		}
	
		public void removeProduct() {
	
			remove.click();
	
			WebElement cont = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(Continue));
			cont.click();
	
		}
	
	}

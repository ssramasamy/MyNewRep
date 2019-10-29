package com.qa.rsautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.rsautomation.base.TestBase;

public class LoginPage extends TestBase {
	
	
	@FindBy(xpath = "//h1[@class='heading_1J5QW']")
	WebElement LoginHeader;

	@FindBy(name = "username")
	WebElement Username;

	@FindBy(name = "password")
	WebElement Password;

	@FindBy(xpath = "//button[@type = 'submit']")
	WebElement Loginbutton;
	
	@FindBy (xpath = "//a[@id='js-logInOut']")
	WebElement logout;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyloginpageheader() {

		WebElement loginheader = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.elementToBeClickable(LoginHeader));
		return loginheader.getText();

	}
	
	public void enterLoginDetails(String username, String password){
		
		Username.sendKeys(username);
		Password.sendKeys(password);
		Actions actions = new Actions(driver);
		actions.doubleClick(Loginbutton).perform();
		Loginbutton.click();
		 
		}
	
	public void clickLogout(){
		logout.click();
	}
	
}
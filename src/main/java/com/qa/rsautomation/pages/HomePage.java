package com.qa.rsautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.rsautomation.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath = "//a[@class='rslogo']")
	WebElement homepagelogo;
	
	@FindBy(xpath = "//a[@title='Log In']")
	WebElement Login;
	
	public HomePage()
	
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public String verifyhomepageTitle()
	{
		return driver.getTitle();
	}
	public boolean verifyhomepageLogo(){
		
		WebElement homelogo = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.elementToBeClickable(homepagelogo));
		return homelogo.isDisplayed();
		
	}
	public void clickLoginLink(){
		
		Login.click();
	}
	
}

package com.qa.auto.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.auto.helper.BrowserFactory;
import com.qa.auto.helper.FunctionlLibrary;

/**
 * 
 * @author Prince Khanna
 *
 */
public class HomePage {

	FunctionlLibrary misc;

	public HomePage(BrowserFactory browserFctry) {
		PageFactory.initElements(browserFctry.getDriver(), this);
		misc = new FunctionlLibrary(browserFctry);
	}

	@FindBy(xpath = "//a[text()='Apply']")
	public static WebElement apply;
	
	@FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
	public static WebElement acceptButton;

	public void clickSignIn() {
		misc.elementClick(apply);
	}

	
	public void acceptCookies() {
		misc.wait(2000);
		misc.elementClick(acceptButton);
	}
}

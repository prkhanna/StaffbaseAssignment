package com.qa.auto.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.qa.auto.helper.BrowserFactory;
import com.qa.auto.helper.FunctionlLibrary;

/**
 * 
 * @author Prince Khanna
 *
 */
public class ApplyPage {
	
	
	FunctionlLibrary misc;

	public ApplyPage(BrowserFactory browserFctry) {
		PageFactory.initElements(browserFctry.getDriver(), this);
		misc = new FunctionlLibrary(browserFctry);
	}

	@FindBy(xpath = "//input[@id='first_name']")
	public static WebElement firstName;

	@FindBy(xpath = "//input[@id='last_name']")
	public static WebElement lastName;
	
	@FindBy(xpath = "//input[@id='email']")
	public static WebElement email;
	
	@FindBy(xpath = "//input[@id='phone']")
	public static WebElement phone;
	
	@FindBy(xpath = "//input[@id='job_application_answers_attributes_0_text_value']")
	public static WebElement visaStatus;
	

	@FindBy(xpath = "//textarea[@id='job_application_answers_attributes_2_text_value']")
	public static WebElement url;
	
	@FindBy(xpath = "//button[@aria-describedby='resume-allowable-file-types']")
	public static WebElement resumeBtn;
	
	@FindBy(xpath = "//button[@aria-describedby='cover_letter-allowable-file-types']")
	public static WebElement coverLtrBtn;

	@FindBy(xpath = "//input[@id='submit_app']")
	public static WebElement submit;
	
	@FindBy(xpath = "//span[@id='select2-chosen-1']")
	public static WebElement policy;
	
	@FindBy(xpath= "//ul[@class = 'select2-results']")
	public static WebElement accept;
	
	@FindBy(xpath= "//h1[text()='Thank you for applying.']")
	public static WebElement successMessage;
	
	@FindBy(xpath= "//iframe[@id='grnhse_iframe']")
	public static WebElement frameLocator;
	
	String frameId="grnhse_iframe";
	String folder = "data";
	String resume="Prince_Khanna_Resume.pdf";
	String coverLetter = "Prince_Khanna_CoverLetter.Pdf";

	public void enterPersonalDetails() {
		JsonObject data = misc.getJsonData();
		
		misc.switchToIframe(frameId);
		misc.elementSendKeys(firstName, data.get("firstName").toString());
		misc.elementSendKeys(lastName, data.get("lastName").toString());
		misc.elementSendKeys(email, data.get("email").toString());
		misc.elementSendKeys(phone, data.get("phone").toString());
		misc.uploadFile(resumeBtn,folder,resume);
		misc.uploadFile(coverLtrBtn,folder,coverLetter);
		misc.elementSendKeys(visaStatus, data.get("visaStatus").toString());
		misc.wait(2000);
		misc.elementClick(policy);
		misc.elementClick(accept);
		misc.elementSendKeys(url, data.get("url").toString());
		misc.elementClick(submit);
		misc.wait(4000);	
	}

	
	public void getSuccessMessage() {
		String actualText = misc.elementGetText(successMessage);
		String expectedText = "Thank you for applying.";
		Assert.assertEquals(actualText, expectedText);
	}
	

}

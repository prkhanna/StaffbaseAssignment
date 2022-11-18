package com.qa.auto.stepdefinitions;

import com.qa.auto.pages.ApplyPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * 
 * @author Prince Khanna
 *
 */
public class Apply {

	ApplyPage applyPage;

	public Apply(ApplyPage applyPage) {
		this.applyPage = applyPage;
	}

	@When("User enters application details")
	public void checkPersonalDetails() {
		applyPage.enterPersonalDetails();
	}

	
	@Then("I validate the confirmation message")
	public void confirmationMessage() {
		applyPage.getSuccessMessage();
	}

}

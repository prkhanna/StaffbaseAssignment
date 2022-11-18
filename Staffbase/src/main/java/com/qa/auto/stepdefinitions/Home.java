package com.qa.auto.stepdefinitions;

import com.qa.auto.pages.HomePage;

import io.cucumber.java.en.Given;

/**
 * 
 * @author Prince Khanna
 *
 */
public class Home {

	HomePage homePage;

	public Home(HomePage homePage) {
		this.homePage = homePage;
	}

	@Given("User clicks on apply button")
	public void signInButtonClick() {
		homePage.clickSignIn();
	}

	@Given("User accept the cookies")
	public void acceptCookies() {
		homePage.acceptCookies();
	}
}

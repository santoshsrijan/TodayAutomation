package com.todayapp.stepdefinitions;

import com.todayapp.pageobjects.ArticleLandingPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class ArticleLandingPageStepDefinitions extends ArticleLandingPage{
	
	
	
	@And("user opens the article")
	public void user_opens_the_article() throws InterruptedException {
		
		clickArticle();
		
	}
	
	@Then("user should see the nav bar on top of the page")
	public void user_should_see_the_nav_bar() throws InterruptedException {
		
		verifyNavBar();
	}
	
	
	@Then("user click back button")
	public void user_click_back_button() throws InterruptedException {
		clickBackButton();
	}

}

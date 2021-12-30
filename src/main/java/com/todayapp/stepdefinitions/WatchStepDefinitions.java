package com.todayapp.stepdefinitions;

import com.todayapp.pageobjects.WatchPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WatchStepDefinitions extends WatchPage{
	
	
	@When("user click the menu on homepage")
	public void user_click_the_menu_on_homepage() throws InterruptedException {
		clickMenu();
	}
	
	
	


	@And("user click the watch button")
	public void user_click_the_watch_button() throws InterruptedException {
		clickWatchButton();
	}
	
	


	@Then("Verify that watch landing screen is displayed")
	public void verify_that_watch_landing_screen_is_displayed() throws InterruptedException {
		watchLandingScreen();
	}


	

}

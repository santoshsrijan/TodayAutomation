package com.todayapp.stepdefinitions;

import com.todayapp.pageobjects.SearchPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class SearchPageStepDefinitions extends SearchPage{

	@Then("I click on search icon")
	public void i_click_on_search_icon() throws InterruptedException {

		clickSearch();
	}

	@Then("I verify the placeholder of search bar")
	public void i_verify_the_placeholder_of_searchbar() throws InterruptedException {

		verifySearchPlaceHolder();
	}
	
	@And("I click close")
	public  void i_click_close() {
		clickClose();
	}
	

}

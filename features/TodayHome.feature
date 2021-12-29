Feature: Today App Home Feature 

#scenario 1
@home 
Scenario: User should be able to see the minute menu is highlighted 

	When I am in app splash screen in today app 
	And I click on minute menu 
	And I verify the minute menu is selected 
	
	#scenario 2
   @Smoke
 Scenario: Open app and access homepage and assert that Top News section is displayed. 

	When Verify The app is opened 
	Then Verify the home page is displayed 
	#Then Verify Top News section is displayed 
	
	
	#scenario 3
	 @Smoke
	Scenario: Open app and access homepage and assert that Share button in HomePage is functional
	
	When Verify The app is opened
	Then Navigate to news article
	And click on three tripel dots
	#Then Verify share button is displayed
	And click on share button
	Then Verify share button is functional
	
	
	#scenario 1
@home 
Scenario: User should be able to see the search results with valid data 

	When I am in app splash screen in today app 
	And I click on search button 
	And I enter the "singapore" search text 
	Then I should see the "singapore" search results 
	
	
	#scenario 1
@invalidsearch 
Scenario: User should see the error message with invalid search data 

	When I am in app splash screen in today app 
	And I click on search button 
	And I enter the "xyz" search text 
	Then I should see the "xyz" error message 
	
	
	
	
	
	#scenario 2
@home 
Scenario: User should be able to see the lates news menu is highlighted 

	And I click on Latest news menu 
	And I verify the latest news menu is selected 
	
	#scenario 3
@home 
Scenario: User should be able to see the Menu button is highlighted 


	And I click on Menu button 
	And I verify the menu button is selected 
	
	#scenario 4
@home 
Scenario: User should be able to see the home button is highlighted 


	And I click on home button 
	And I verify the home button is selected 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
 
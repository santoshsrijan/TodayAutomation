Feature: Today App Search functionality

#scenario 1
@Smoke
Scenario: User should be able tap on search icon

	When Verify The app is opened
	Then I click on search icon
	Then I verify the placeholder of search bar
	Then I click close
	
	
	
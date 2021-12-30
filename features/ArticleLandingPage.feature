Feature: Article Landing Page

@Smoke
Scenario: Open app and access homepage and access one of article detail and assert that nav bar is displayed



When Verify The app is opened
And user opens the article
Then user should see the nav bar on top of the page
#Then user click back button

Feature: Logout

Scenario: Successful Logout
Given User Launch Chrome browser
When User opens URL "https://demo.guru99.com/v4/"
And User enters Email as "mngr453435" and Password as "sumequr"
And Click on Login
Then Page Title should be "Guru99 Bank Manager HomePage"
When User clicks on Logout
Then User should see an alert with "You Have Succesfully Logged Out!!"
And close browser
Feature: change password

Scenario: User should be able to change password 

Given User Launch Chrome browser
When User opens URL "https://demo.guru99.com/v4/"
And User enters Email as "mngr453435" and Password as "sumequr"
And Click on Login
Then Page Title should be "Guru99 Bank Manager HomePage"
When user cliks on change password
Then User should see a message like "Change Password"
When User enter required info
And User clicks on submit
Then User should see a message like "Password changed successfuly"
Given User Launch Chrome browser
When User opens URL "https://demo.guru99.com/v4/"
And User enters Email as "mngr453435" and Password as "sumequr"
And Click on Login
Then Page Title should be "Guru99 Bank Manager HomePage"
When User clicks on Logout
Then User should see an alert with "You Have Succesfully Logged Out!!"
And close browser

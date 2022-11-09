Feature: Login with valid credantials

Scenario: Successful Login with Valid Credentials

Given User Launch Chrome browser
When User opens URL "https://demo.guru99.com/v4/"
And User enters Email as "mngr453435" and Password as "sumequr"
And Click on Login
Then Page Title should be "Guru99 Bank Manager HomePage"
And close browser
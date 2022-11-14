Feature: Add New Account

Scenario: User should be able to add account succesfully
Given User Launch Chrome browser
When User opens URL "https://demo.guru99.com/v4/"
And User enters Email as "mngr453435" and Password as "sumequr"
And Click on Login
Then Page Title should be "Guru99 Bank Manager HomePage"
When User clicks on add new account
Then User should see an message like "Add new account form"
When User enter CustomerId as "123" and AccountType as "Current" and initialDeposit as "1000"
And User cliks on Submit
Then Page Url should be "https://demo.guru99.com/v4/manager/insertAccount.php" 
And close browser
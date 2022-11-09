Feature: register with using emailId

Scenario: Successful Register with Valid emailId
Given User Launch Chrome browser
When User opens URL "https://demo.guru99.com/v4/"
And User cliks on here link
Then User should see message displayed 
When User enter email address "omarmghofel@gmail.com"
And Clicks on submit
Then User should see sucsess message like "Access details to demo site."
And close browser
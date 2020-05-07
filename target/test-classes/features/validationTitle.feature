Feature: Validation all title on HomePage

  Scenario: Postive test validation
    Given Initialize the browser
      And Navigate to "http://www.qaclickacademy.com/" site
      And Validate first title message
      And Validate second title message
      And Validate second email
      And Validate phoneNumber
      And close browser
  
   Scenario: Validation navigation Bar on HomePage
    Given Initialize the browser
      And Navigate to "http://www.qaclickacademy.com/" site
     And Check navigation bar is displayed
     Then Number of navigation bar should be ten
      And close browser
    
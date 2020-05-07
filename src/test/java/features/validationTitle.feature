Feature: Validation all title on HomePage

  Scenario: Postive test validation title
    Given Initialize the browser
      And Navigate to "http://www.qaclickacademy.com/" site
      And Validate first title message
      And Validate second title message
      And Validate second email
      And Validate phoneNumber
      And close browser
  
    
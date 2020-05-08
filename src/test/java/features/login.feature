Feature: Login into QAClickAcademy page
 

  Scenario Outline: Postive test validation login
    Given Initialize the browser
      And Navigate to "http://www.qaclickacademy.com/" site
      And Click on Login
     When User enters <username> and <password>
     Then User is successfully logged in
      And close browser
  
    Examples: 
  
      | username                  | password | 
      | ira.maksmumic88@gmail.com | 123456   | 
      
  
  
  Scenario Outline: negativ test validation login
    Given Initialize the browser
      And Navigate to "http://www.qaclickacademy.com/" site
      And Click on Login
     When User enters <username> and <password>
     Then User is not login successfully
     And Validation error message
      And close browser
       
       Examples: 

       | username                  | password | 
       |ira.zildzo@gmail.com       | 33458678 | 

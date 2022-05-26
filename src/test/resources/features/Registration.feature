Feature: Company Registration 

  Scenario: Successful company registration on demo.saloodo website 
    Given I am on demo.saloodo website
    When I click on Register link  
    And after filling details I click on Register Now button 
    Then Registration successful message displayed



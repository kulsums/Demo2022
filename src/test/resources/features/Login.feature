
Feature: Login 

  Scenario: Successful login to demo.saloodo website 
    Given I am on demo.saloodo website
    When I click on Login link  
    And After entering username and password I click on Login In button
    Then successfull login validated with profile initials
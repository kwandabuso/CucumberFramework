Feature: @AddEmployeelist

Scenario: Login with right username and password
  Given I am on a login page
  When I enter the following details for credentials
  And I click a login button
  Then I should be logged in


  Scenario: Navigate to employee list page
    Given I am on the home page
    When I click on Employee List
    Then A list of employees is displayed


  Scenario: navigate to add new employee page
    Given I am on the employee list page
    When I click the add new button
    And I enter all the field details
    And I click the create button
    Then A new employee is displayed on the list
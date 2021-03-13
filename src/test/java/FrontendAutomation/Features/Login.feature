Feature: login to sauce demo



Scenario: login entering no fields
  Given I am on the sauce demo login page
  When click the login button
  Then an error message must be displayed

  Scenario: login entering a valid username and an invalid password
    Given I am on the sauce demo login page
    When I enter a valid username and an invalid password
    And click the login button
    Then an error message must be displayed

  Scenario: login entering an invalid username and a valid password
    Given I am on the sauce demo login page
    When I enter an invalid username and a valid password
    And click the login button
    Then an error message must be displayed

  Scenario: login using the right credentials
    Given I am on the sauce demo login page
    When I enter a valid password and a valid username
    And click the login button
    Then I must be logged in

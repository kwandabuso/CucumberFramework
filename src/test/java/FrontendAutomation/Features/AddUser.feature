Feature: Add New User

  Scenario: navigate to add new user modal
    Given I am on the wayautomation page
    When click the add new user button
    Then new modal window is displayed

    Scenario: add new user
      Given I enter all the required info
      When  I click on the Save button
      Then The user is displayed on the grid
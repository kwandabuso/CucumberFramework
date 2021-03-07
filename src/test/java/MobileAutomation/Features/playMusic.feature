Feature: @AddEmployeelist

Scenario: navigate to albums
  Given I am on the uamp application
  When I click on Albums
  Then then albums must be displayed

  Scenario: play my favourite music
    Given I am on the albums menu
    When I click on jazz and blues
    And I select A song
    Then the selected song must play
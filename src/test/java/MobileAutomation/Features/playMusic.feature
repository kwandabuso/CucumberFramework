Feature: @play my favourite song

Scenario: navigate to albums
  Given I am on the uamp application
  When I click on genres
  Then then a list of available genres is displayed

  Scenario: play my favourite music
    Given I am on the genres menu
    When I click on jazz and blues
    And I select A song
    Then the selected song must play
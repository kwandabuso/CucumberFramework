Feature: login to sauce demo

  Scenario: add Items to cart
    Given I am on the sauce demo products page
    When I select an item
    Then the Item must be added to the cart


Scenario: view cart items
  Given I am on the sauce demo products page
  When I click on the cart icon
  Then the cart is displayed


Scenario: checkout my cart
  Given I am on the cart page
  When I click on the checkout button
  Then your information page is displayed

  Scenario: enter your information
    Given I am on the your information page
    When I enter all the fields
    And click on the continue button
    Then Checkout Overview page is displayed

    Scenario: finish your order
      Given I am on the overview page
      When I click on the Finish Page
      Then  My order must be placed

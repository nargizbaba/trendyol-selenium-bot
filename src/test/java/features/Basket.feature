@Basket
Feature: Basket

  Scenario: Adding items to basket
    Given after choosing desired product the user clicks on add to basket button
    When the user clicks on the basket button and sees the product there
    Then the user decreases the amount of the item selected
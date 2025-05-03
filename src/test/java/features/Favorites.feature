@Favorites
  Feature: Favorites

    Scenario: Adding items to Favorites
      Given the user searches for a desired item
      When the user clicks on the desired item
      And the user adds the item to favorites
      Then the user clicks on the favorite button and sees the products there
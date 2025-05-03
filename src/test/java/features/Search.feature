@Search
  Feature: Search

    Scenario: Searching for an item
      Given the user clicks on search button
      When the user searches for gloves
      And the user clicks on the desired product
      Then the user chooses its size
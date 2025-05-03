@Filter
  Feature: Filtering products

    Scenario: The user filters about a product
      Given The user searches for an item
      When The user searches for categories of the item
      And The user searches for the brand of the item
      Then The user decides on the color
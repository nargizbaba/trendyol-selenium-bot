@Login
Feature: Login function

  Scenario: Successful login with valid credentials
    Given the user is on the Trendyol homepage
    And the user clicks on countries' button and selects Turkey option
    When the user clicks on Login and login button
    And the user writes email and password
    Then the user clicks on login button and redirected to homepage
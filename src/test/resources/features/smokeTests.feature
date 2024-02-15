Feature: Smoke tests for T-Moble website

  @SmokeTest
  Scenario: Choose smartwatch from the list of offers
    Given I am on the home page
    When I choose "Urządzenia" from header
    Then Header dropdown list is visible
    When I choose "Bez abonamentu" from "Smartwatche i opaski" column
    Then List of products is visible
    When I choose first product from the list
    Then I see product page
    When I add product to the basket
    Then I see basket page
    And Visible prices are the same as seen previously
    When I go to home page
    Then I see home page view
    And I see basket with quantity <1> visible

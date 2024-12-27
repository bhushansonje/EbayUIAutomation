Feature: Add to Cart

  Scenario: Verify item can be added to the cart
    Given I am on the eBay home page
    When I search for a book
    And I select the first item from the search results
    And I add the item to the cart
    Then the cart count should be updated
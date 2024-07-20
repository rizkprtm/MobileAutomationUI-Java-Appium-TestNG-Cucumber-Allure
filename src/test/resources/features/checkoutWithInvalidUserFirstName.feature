@InvalidUserFirstNameCheckout
Feature: Checkout with invalid user firstname

  @NegativeCase
  Scenario Outline: Checkout with invalid user firstname
    And Verify user already on product list page
    When User tap filter button
    And User set filter the list of product by price low to high
    Then User tap add to cart button from product list page
    When User tap cart button from product list page
    When User tap checkout button navigate to checkout information page
    And User fill credentials "<firstName>" as firstName, "<lastName>" as lastName and "<postal_code>" as postal code
    And User tap continue checkout
    Then Continue checkout is failed with an error "<errMsg>"
    Examples:
      | firstName | lastName | postal_code | errMsg                 |
      |           | Pratama  | 16439       | First Name is required |
@EndToEndCheckout
  Feature: Complete checkout with valid user

    Scenario Outline: Checkout with valid user
      Given User logged in with username as "standard_user" and password as "secret_sauce"
      And Verify user already on product list page
      When User tap filter button
      And User set filter the list of product by price low to high
      And Verify filtered first product name
      Then User tap add to cart button from product list page
      And User tap filter button for the second time
      And User set filter the list of product by price high to low
      And Verify filtered second product name
      When User tap second product to navigate second product details
      And User tap add to cart button from product details page
      Then User tap cart button to navigate cart page
      And Verify multiple products in cart page
      And User tap continue shopping and redirect to product list page
      When User tap cart button to navigate cart page
      And Verify details of the product added into the cart
      When User tap checkout button to navigate checkout information page
      And User fill valid credentials "<firstName>" as firstName, "<lastName>" as lastName and "<postal_code>" as postal code
      When User tap continue checkout to navigate checkout overview page
      And Verify payment confirmation
      And Verify shipping infomation
      And Verify checkout product price
      When User tap finish checkout to navigate complete checkout page
      And Verify complete checkout message after checkout
      Then User tap back home button

      Examples:
        | firstName | lastName | postal_code |
        | Rizki     | Pratama  | 16439       |
        |           | Pratama  | 16439       |



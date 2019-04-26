Feature: Checkout


  @new
  Scenario Outline: Apply discount

    Given he go to home page
    When add default item to basket
    And go to shopping cart
    And apply discount with code "<code>"
    Then the success message should be shown "Entered coupon code"

    Examples:
      | code |
      | 123  |
      | 456  |

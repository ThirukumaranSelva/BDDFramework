Feature:Products Details Screen

  Scenario Outline: Verify the product information in Products page
    Given User logged in successfully
    When User verify product name "<productName>" and product price "<productPrice>"
    Examples:
      | productName         | productPrice |
      | Sauce Labs Backpack | $29.99       |

  Scenario Outline: Verify product detailed information
    Given User logged in successfully
    When User clicks on product name "<productName>"
    Then User landed to product Detailed view page
    * verify product title "<productTitle>" and verify product description "<productDescription>"
    Examples:
      | productName         | productTitle | productDescription                                                                                                                     |
      | Sauce Labs Backpack | $29.99       | carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection. |
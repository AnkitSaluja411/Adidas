Feature: Demoblaze

  Background:

    Given I launch the url "https://www.demoblaze.com/index.html"

  @ShopOnDemoblaze
  Scenario Outline: Purchase items on Demoblaze

    Given I navigate to <category> category on homepage
    When I click on <product_1> product
    And I click on 'Add to cart' button on Product page
    And I Accept pop up confirmation on Product page

    And I click on "Home" link
    Then I verify that 'Home' page should be displayed

    When I navigate to <category> category on homepage
    And I click on <product_2> product
    And I click on 'Add to cart' button on Product page
    And I Accept pop up confirmation on Product page

    And I click on "Cart" link

    And I delete <product_2> from the Cart

    And I calculate the total amount

    And I click on "Place Order" button

    And I enter details on Place Order popup
      | Name        | NAME     |
      | Country     | COUNTRY  |
      | City        | CITY     |
      | Credit card | 20225678 |
      | Month       | 03       |
      | Year        | 2020     |

    And I click on 'Purchase' button on Place Order window

    And I Capture and log purchase Id and Amount

    Then I verify that Assert purchase amount should be equal to the expected amount

    When I click on "OK" button

    Then I verify that 'Home' page should be displayed

    Examples:

      | category | product_1    | product_2   |
      | Laptops  | Sony vaio i5 | Dell i7 8gb |












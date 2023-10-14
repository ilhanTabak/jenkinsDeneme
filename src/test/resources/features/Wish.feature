@smoke
@ilhan
@B7KCLS-104
Feature: Wish List

  Background:
    Given The user is logging in with valid credentials

     @B7KCLS-126

  Scenario: The user can see products in the wish list
    Given The user on the all product page
    When The user select a products wish button
    Then The user see produkt in the wish list

     @B7KCLS-127

    Scenario: The user delete products from wish list
      Given The user on the all product page
      When The user select a products wish button
      Then The user can delete a product from wish list




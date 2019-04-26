Feature: Business Listing

  Background:
    Given I insert the data into the database

  Scenario: User should be able to see the list of businesses in the order of posting

    Given user search with keyword "Iphone XS"
    Given User is in business listing page
    When he goes for first time
    Then the list of businesses should be shown
    And the sorting order should be as per the time lines the ad is posted


  Scenario Outline: The details of listing should be as per below

    Given user search with keyword "Iphone XS"
    Given User is in business listing page
    Then he should see the below business <Title> <Desc> <Location> <timeline>

    Examples:
      | Test case | Title                                  | Desc                                           | Location              | timeline    |
      | default   | Shoes Nike                             | This shoes ar used just 3 time The size it’s 8 | Seven Sisters, London | 19 days ago |
      | No image  | House price negotiator (NO WIN NO FEE) | Looking to buy a house or flat?                | Earls Court, London   | 46 days ago |

  Scenario: If non data found then the default page is show with message

    Given user search with keyword "Iphone XX"
    Given User is in business listing page
    Then he should see "Sorry we didn't find any results for 'iphone xx' within London" if there no matching


@search
Feature: Search

  @reg
  Scenario Outline: Basic search from a user which have results

    Given he go to search page
    When search with keyword "<Keyword>"
    Then he should see atleast one result
  @smoke
    Examples:
      | Keyword  |
      | Computer |

    Examples:
      | Keyword  |
      | 5.0      |


  Scenario Outline: Basic search from a user which dont have results

    Given he go to search page
    When search with keyword "<Keyword>"
    Then he should see a message "<Message>"

    Examples:
      | Keyword | Message                                            |
      | Invalid | No products were found that matched your criteria. |
      | 5121212 | No products were found that matched your criteria. |
      |         | Search term minimum length is 3 characters         |


  Scenario: Advanced search


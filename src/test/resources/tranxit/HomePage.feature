
Feature: Home page

  Background:
    Given he go to home page

    @debug
  Scenario Outline: Social media links

    When he open the "<Social media link>" link
    Then the page in new TAB should be open with text "<Expected Text>"

    Examples:
      | Social media link | Expected Text  |
      | Facebook          | Email or Phone |
#      | Twitter           | Tweets         |


  Scenario Outline: Footer links

    When he open the Footer link "<Page>"
    Then the page should be open with text "<Page>"

    Examples:
      | Page |
      | Search |
      | News   |
      | Blogs  |


  Scenario: New letter

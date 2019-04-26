
Feature:User accounts



  Scenario: User should able to land home page

    Then he should see a welcome message

@login
  Scenario Outline: User should be able to login successufully with valid credentials

    And user is in login page
    When us enters user name as "<Username>" and password as "<Password>"
    Then he should be successfully login
    And logout from the system

    @smoke
    Examples:
      | Username        | Password |
      | demo1@demo1.com | 1234567  |

   Examples:
      | Username        | Password |
      | demo2@demo2.com | 1234567  |
      | demo3@demo3.com | 1234567  |

  Scenario Outline: User should not be login with invalid credentials

    Given user is in login page
    When us enters user name as "<Username>" and password as "<Password>"
    Then he should be not be login

    Examples:
      | Username       | Password   |
      | demo2@demo.com | 1212       |
      | demo2          | 1234567    |
      |                |            |
      | *(^(*£@(*&     | )@£*)(£$&* |


#    Given he go to home page
#    Given user is in login page
#    When us enters user name as "<Username>" and password as "<Password>"
#    And try to login
#
#      | username | password | first | lastname | email
##  demo1
#
#
#    Background:
#      Page objects
#      Page Factory
#      Cucumber reports
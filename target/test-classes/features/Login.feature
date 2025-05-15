@RunAll
Feature: Login functionality on SauceDemo

  Background: 
    Given the user is on the SauceDemo login page

  @Sanity 
  Scenario Outline: Successful login with valid credentials
    When the user enters a valid "<username>" and "<password>"
    And clicks the login button
    Then the user should be redirected to the product_page

    Examples: 
      | username        | password     |
      | standard_user   | secret_sauce |
      | locked_out_user | secret_sauce |
      | problem_user    | secret_sauce |
      | standard_user   | secret_sauce |

  @Regression
  Scenario Outline: Unsuccessful login with invalid credentials
    When the user enters an invalid "<username>" or "<password>"
    And clicks the login button
    Then the user should see an error message

    Examples: 
      | username       | password      |
      | standard_user  | wrong_pass    |
      | unknown_user   | secret_sauce  |
      | standard_user2 | secret_sauce1 |

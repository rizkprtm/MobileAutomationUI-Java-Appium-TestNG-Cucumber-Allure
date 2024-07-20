@InvalidLogin
Feature: Invalid login scenarios

  @NegativeCase
  Scenario Outline: Login with invalid credentials
    Given User enter username as "<invalidUsername>" and password as "<invalidPassword>"
    When User tap login button
    Then Login failed with an error "<errMsg>"

    Examples: Credentials Data
      | invalidUsername | invalidPassword | errMsg                                                       |
      | locked_out_user | secret_sauce    | Sorry, this user has been locked out.                        |
      | standard_user   | secret          | Username and password do not match any user in this service. |
Feature: Application Login

  Scenario: Successful Login with Valid Credentials
    # This line must EXACTLY match the string in the @Given annotation
    Given I am on the login page
    When User enters valid username and password
    Then User should be successfully logged in

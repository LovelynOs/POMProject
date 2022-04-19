Feature: Test login functionality

  Scenario Outline: To check login is successful with valid credentials
    Given browser is open
    And user is on login page
    When user enters "<username>" and "<password>"
    And clicks login
    Then user is navigated to the home page

    Examples:
      | username | password |
      | Kundan   | 12345    |
      | Varsha   | 12345    |
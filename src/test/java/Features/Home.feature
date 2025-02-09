Feature: validate navigation links
  Background:
    Given User navigates to login page
    When User enters username and password
    And clicks on login button
    Then User navigates to Homepage

  @TC003
    Scenario: validate navigation links
      Then User able to see all Navigation links
        |Open New Account|
        |Accounts Overview|
        |Transfer Funds   |
        |Bill Pay         |
        |Find Transactions|
        |Update Contact Info|
        |Request Loan       |
        |Log Out            |
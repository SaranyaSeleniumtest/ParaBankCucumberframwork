@Login
Feature: Login Functionalites
  @TC001-Login-validcrendtials
Scenario: Verify login functionality
  Given User navigates to login page
  When User enters username and password
  And clicks on login button
  Then User navigates to Homepage


  @TC002-Login-invalidcredentials
  Scenario Outline: Verify login functionality with invalid credentials
    Given User navigates to login page
    When User enters "<username>" and "<password>"
    And clicks on login button
    Then User navigates to Homepage
    Examples:
    |username|password|
    |@@@test122|testing |
    |##tester2|password|

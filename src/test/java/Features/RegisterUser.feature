@Register
Feature: Register User to parabank
Background:
  Given User navigates to login page
  When User clicks on Register link
  When User enters FirstName, LastName,Address,City,State,ZipCode,Phone,SSN

  @TC003-Register
  Scenario: Register User account to parabank
    And  User enters UserName,Password,ConfirmPassword
    And  Clicks on Register
    Then User should be able to succesfully register an account




  @TC004-SameUserRegister
  Scenario: Register User account failed if already user exists
    And  User enters same UserName,Password,ConfirmPassword
    And  Clicks on Register
    Then User should not be allowed to registered with same User

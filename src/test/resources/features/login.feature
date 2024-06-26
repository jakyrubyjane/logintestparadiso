Feature: Login

  Scenario: Successful login with valid credentials
    Given I am on the login page
    When I enter the name "merchant"
    And I enter the email "merchant@mail.com"
    And I enter the password "password"
    And I click the login button
    Then I should be redirected to the dashboard page

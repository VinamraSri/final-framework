Feature: E2E Test

  Background:
    Given I am on login page

  Scenario: Successfully login with valid credentials
    When I enter the username "tomsmith" and password "SuperSecretPassword!"
    And I click on "submit" button
    Then I should see the message "You logged into a secure area!"
    And I should see the page title "Secure Area"
    And I should see the logout button visible

  Scenario: Unsuccessfully login with invalid credentials
    When I enter the username "tomsmith1" and password "SuperSecretPassword!"
    And I click on "submit" button
    Then I should see the error message "Your username is invalid!"

  Scenario: Successfully redirect to login page
    When I enter the username "tomsmith" and password "SuperSecretPassword!"
    And I click on "submit" button
    Then I should see the message "You logged into a secure area!"
    And I click on logout button
    Then I should redirect to login page

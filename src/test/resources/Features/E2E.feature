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


    Scenario: Successfully check the check bok
      When I am on checkbox page
      And I wait for 2 second
      Then I check the checkbox number "1"
      And I wait for 2 second
      And checkbox "1" should be selected
      And checkbox "2" should be selected

    Scenario Outline: Successfully select the value from dropdow
      When I am on dropdown page
      And I wait for 2 second
      And I select "<option>" from dropdown
      And I wait for 1 second
      Then I see the "<option>" selected
      Examples:
        |option  |
        |Option 1|
        |Option 2|


    Scenario: Verify dynamic loading page
      When I am on dynamic loading page
      And I click on start button
      Then I see the "Hello World!"

    Scenario: Verify Alert
      When I am on alert page
      And I wait for 1 second
      And I click on Alert button
      Then I see the alert message "I am a JS Alert"
      And I wait for 1 second
      And I accept the alert
      And I wait for 1 second

  Scenario: Find Email Id of Last name
    When I am on data table page
    And I wait for 1 second
    And the email id for "Doe" is "jdoe@hotmail.com"

  Scenario: Successfully login with valid credentials through data table
    When I enter the credentials
      |user        |tomsmith            |
      |password    |SuperSecretPassword!|
    And I click on "submit" button
    Then I should see the message "You logged into a secure area!"
    And I should see the page title "Secure Area"
    And I should see the logout button visible

Feature: User Registration and Login

  Scenario: Register a new user and login
    Given I am on the Parabank home page
    When I click on the "Register" link
    And I fill in the registration form with random data
    And I submit the registration form
    Then I should see the success message "Your account was created successfully. You are now logged in."
    When I navigate back to the Parabank home page
    And I log in with the newly created account
    Then I should see the welcome message
@login
Feature: Test login

  Scenario: Login Success and Failure
    Given I navigate to the mock application
    When I try to login with 'valid' credentials
    Then I should see that I logged in 'successfully'

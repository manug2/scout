@login
Feature: Test login

  Scenario: Login Success
    Given I navigate to the mock application
    When I try to login with 'manu' and 'pass'
    Then I should see that the login attempt 'succeeded'

  Scenario: Login Failure
    Given I navigate to the mock application
    When I try to login with 'xyz' and 'nopass'
    Then I should see that the login attempt 'failed'

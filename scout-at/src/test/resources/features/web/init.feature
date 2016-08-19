@init
Feature: Test load application web page

  Scenario: Load initial web page
    Given I navigate to the mock application
     Then I should check that title is 'Scout Web'
      And Login page is displayed

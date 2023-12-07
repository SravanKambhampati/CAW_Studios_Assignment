@DynamicTable
Feature: Dynamic Table

  @testCase
  Scenario: Verifing the insert functionality of dynamic table
    Given I open the Dynamic Table Application
    When Insert the values by reading JSON file
    Then Verify if all the values are inserted inside the table
@files @files_list
Feature: Files List

  Scenario:
    Given I log into the Clarity Service Portal
    And I navigate to the Files Page

 
  @smoke_test
  Scenario: Validate Files list table column headers
    Then the Files List table will have the correct column <column_name> headers
   # | column_name   |
      | FILE NAME     |
      | JOB ID        |
      | STATUS        |
      | % COMPLETE    |
      | ORDERS        |
      | PACKAGES      |
      | ERRORS        |
      | HELD ORDERS   |
      | OVERRIDES     |
      | FILE RECEIVED |
      | ACTIONS       |

      
@smoke_test
Scenario: Validate result count of Files against API count
Then the Files result count will be as expected
      
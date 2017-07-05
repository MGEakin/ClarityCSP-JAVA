@overrides @overrides_list
Feature: SCR_073a Overrides (LIST)

 Scenario:
    Given I log into the Clarity Service Portal
    And I navigate to the Overrides Page

 
  @smoke_test
  Scenario: Validate Overrides list table column headers
    Then the Overrides List table will have the correct column <coloum_name> headers
     #| column_name     |
      | OVERRIDE ID     |
      | TYPE            |
      |CRITERIA         |
      | EFFECTIVE DATE  |
      | EXPIRATION DATE |
      | AUTHOR          |
      | AFFECTED ORDERS |
      | STATUS          |
      |ACTIONS          |


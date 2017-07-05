@orders @orders_list @scr_055b
Feature: SCR_055b Orders (List)

  Scenario:
    Given I log into the Clarity Service Portal
    And I navigate to the Orders List Page

#    TABLE SECTION
  @smoke_test
  Scenario: validate Orders list table column headers
    Then the Orders List table will have the correct column <column_name> headers
    
     # | column_name    |
      | ORDER ID       |
      | JOB ID         |
      | PRINT ID       |
      | PROCESSED DATE |
      | MEMBER ID      |
      | NAME           |
      | PLAN ID        |
      | GROUP ID       |
      | ADDRESS LINE 1 |
      | CITY           |
      | STATE          |
      | ZIP            |
      | PRODUCT TYPE   |
      |ACTIONS         |

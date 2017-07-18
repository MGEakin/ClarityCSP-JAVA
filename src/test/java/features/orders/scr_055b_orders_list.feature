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

      
@smoke_test
Scenario: Validate Members list table column headers
 Then the Members table will have the correct column <coloum_name> headers 
# | column_name    |
|MEMBER NAME|
|MEMBER ID|
|GROUP ID|
|PLAN TYPE|
|FAMILY ID|
|DATE OF BIRTH|
|ADDRESS LINE 1|
|CITY|
|STATE|
|ZIP|
|ACTIONS|

@smoke_test
Scenario: Validate result count of Members against API count
Then the Members result count will be as expected

@smoke_test
Scenario: Search Members Form by GROUPID - validate breadcrumb
When I search Members Form by GROUPID with a value of "987654"
Then I see the "GroupID: 987654" text on the screen

@smoke_test
Scenario: Search Members Form by groupId - validate API return
	When I search Members Form by GROUPID with a value of "987654"
	Then the Members row content will match the API results     
	

	
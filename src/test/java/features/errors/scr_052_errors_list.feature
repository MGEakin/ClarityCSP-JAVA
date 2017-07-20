@errors_list_and_details @errors_list 
Feature: Errors List 
	SCR_052 Errors List

Scenario: 
	Given I log in using a ClarityTestBooks client 
	And I navigate to the Errors List Page 
	And I am on the Errors List page 
	
	#    TABLE SECTION
@smoke_test 
Scenario: Validate Errors list table column headers 
	Then the Errors table will have the correct column <column_name> headers
	# | column_name       |
	    | DATE    |
		| ERROR DESCRIPTION|
		| RECORD DETAIL    |
		| ACTIONS   |
		
	
@smoke_test 
Scenario: Validate result count of Errors against API count 
	Then the Errors result count will be as expected 
	

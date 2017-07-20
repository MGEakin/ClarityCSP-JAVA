@errors_list_and_details @view_report_window 
Feature: View Report Window 
	SCR_113 View Report Window

Scenario: 
	Given I log in using a ClarityTestBooks client 
	And I navigate to the View Report Window Page 
	And I am on the View Report Window page 


		
@smoke_test 
Scenario: Validate result count of Error Report against API count 
	Then the View Report Window result count will be as expected 
	
# TABLE SECTION
@smoke_test 
Scenario: Validate Error Report table column headers 
	Then the Error Report table will have the correct column <column_name> headers
	# | column_name       |
		|DATE PROCESSED    |
		|JOB ID   |
		|FILE NAME    |
		|ERROR DESCRIPTION   |
		|RECORD DETAIL|
	
	
@admin_notices @notices_list 
Feature: Notices - List 
	SCR_087 Notices

Scenario:
	Given I log into the Clarity Service Portal 
	And I navigate to the Notices Page 

 # TABLE SECTION
@smoke_test 
Scenario: Validate Notices list table column headers 
	Then the Notices table will have the correct column <column_name> headers
	# | column_name       | 
	|EFFECTIVE DATE|
	|EXPIRATION DATE|
	|NOTICE TITLE AND MESSAGE|
	|AUDIENCE|
	|AUTHOR|
	|ACTIONS|
	
@smoke_test
  Scenario: Validate result count of Notices against API count
    Then the Notices result count will be as expected
	

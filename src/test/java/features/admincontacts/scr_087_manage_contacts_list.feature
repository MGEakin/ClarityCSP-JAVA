@admin_contacts @manage_contacts_list 
Feature: Manage Contacts 
	SCR_087 Manage Contacts

Scenario: 
#Given I log in using a ClarityTestMiniKit client
	Given I log into the Clarity Service Portal
	#And I navigate to manage Contacts Page 
	And I navigate to the manage contacts Page
	

#    TABLE SECTION
@smoke_test
  Scenario: Validate Manage Contacts list table column headers
	Then the Manage Contacts table will have the correct column <column_name> headers
# | column_name       | 
	|SUPPORT ROLE|
	|CONTACT COMPANY|
	|CONTACT NAME|
	|CONTACT EMAIL|
	|CONTACT PHONE|
	|HOME DISPLAY|
	|ACTIONS|

	
	
@smoke_test 
Scenario: Validate result count of Manage Contacts against API count 
 Then the Manage Contacts result count will be as expected 

	

	
	
	
	

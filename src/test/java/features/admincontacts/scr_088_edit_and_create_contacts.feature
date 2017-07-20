@admin_contacts @manage_contacts_list 
Feature: Manage Contacts 
	SCR_087 Manage Contacts

Background: 
#Given I log in using a ClarityTestMiniKit client
	Given I log into the Clarity Service Portal  
	And I navigate to the Manage Contacts Page 
	
@smoke_test 
Scenario: Error messages on SCR_088 Edit & Create Contacts form 
	And I click the "Add Contact" button 
	When I enter "m" in the Contact Email field 
	Then I see the text "Invalid format" in the Contact Email Error field 
	When I enter "123" in the Contact Phone field 
	Then I see the text "Contact Phone min length is 7" in the Contact Phone Error 1 field 
	Then I see the text "Invalid format. Enter phone as ### - ### - ####" in the Contact Phone Error 2 field
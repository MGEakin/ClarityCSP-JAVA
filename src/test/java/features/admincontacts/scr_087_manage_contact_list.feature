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

#    HEADERS SECTION
Scenario: Validate Manage Contacts page title and mesasge
 Then I am on the Manage Contacts List page
  And I see the text "Use this screen to manage this client's Clarity and internal contacts." on the Manage Conatcts screen
	
Scenario: Validate Manage Contacts List content is correct
   Then the following Manage Contacts row content will be correct
    | SUPPORT ROLE   |  CONTACT COMPANY  | CONTACT NAME    | CONTACT EMAIL 			 | CONTACT PHONE | HOME DISPLAY  | ACTIONS   |
    |  Day to day    | ClarityTestCards |   ZZZ0325Name  |  	0325@clarityssi.com  | 111-111-0325  |  Yes          |Edit Delete|
      
 Scenario: Action - Edit taken to Manage Contact Details page
  When I select the Manage Contact - Edit action
  Then I am on the Edit and Create Contacts page
 And the following Edit and Create Contacts row content will be correct
 | Contact Name       | Contact Email        | Contact Phone  | Contact Company   | Support Role | Display Contact on Home Page  | New Support Role Name| 
 |     ZZZ0325Name    | 0325@clarityssi.com  | 111-111-0325   | ClarityTestCards  |     New      |            Yes                |     Day to day       |
	
Scenario: Action - Delete Manage Contact - Validate warning message
  When I select the Manage Contact - Delete action
	Then I see the text "Are you sure you want to delete this contact?" on screen

Scenario: Action - Delete Manage Contact - Cancel
    When I select the Manage Contact - Delete action
    And I click on the "Remove Manage Contact - Cancel" button
    Then I do not see the text "Are you sure you want to delete this contact?" on the screen
	And I am on the Manage Contacts List page

  # PAGINATION SECTION
Scenario: Validate Items per page selection count
  And the Manage Contacts list page count display list will contain
   #|page_count |
   | 20         |
   | 50         |
   | 100        |
   	
Scenario: Validate Items per page default value is 20
Then the default page selection is "20"


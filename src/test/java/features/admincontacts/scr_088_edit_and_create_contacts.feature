@admin_contacts @manage_contacts_list 
Feature: Manage Contacts 
	SCR_087 Manage Contacts

Scenario: 
#Given I log in using a ClarityTestMiniKit client
	Given I log into the Clarity Service Portal  
	And I navigate to the Manage Contacts Page 
	
@smoke_test 
Scenario: Error messages on SCR_088 Edit & Create Contacts form 
	And I click the Add Contact button 
	When I enter "m" in the Contact Email field 
	Then I see the text "Invalid format" in the Contact Email Error field 
	When I enter "123" in the Contact Phone field 
	Then I see the text "Contact Phone min length is 7" in the Contact Phone Error 1 field 
	Then I see the text "Invalid format. Enter phone as ### - ### - ####" in the Contact Phone Error 2 field
  
  Scenario: Validate page title and informational text
    And I click on the contacts element "Add Contact" button
    Then I am on the page Edit and Create Contacts page
And I see this text "Use this screen to view, edit, and create Contacts." on the screen

Scenario: Create Contact Required Fields
  Contact Name, Contact Email, Contact Company, Support Role, Display Contact on Home Page
  Contact Phone Not a Required Field
    And I click the Add Contact button 
    And Create Contact - Save button is disabled
    When I enter the name as "Matt Tester" in the Contact Name field
    And Create Contact - Save button is disabled
    When I enter the email id as "matt.tester@mattthetester.com" in the Contact Email field
    And Create Contact - Save button is disabled
    When I enter the contact number as "888-888-8888" in the Contact Phone field
	And Create Contact - Save button is disabled
	When I select the company name as "Clarity" in the Contact Company select list
     And Create Contact - Save button is disabled
    When I select role as "General IT Resource" in the Support Role select list
     And Create Contact - Save button is disabled
    When I select the value as "Yes" in the Display Contact on Home Page select list
 	And Create Contact - Save button is enabled
 	
 Scenario: Cancel button taken back to Edit and Create Contacts List with nothing added
    And I click the Add Contact button 
    And I enter "1111 Matt Tester" in the Contact Name field
    And I enter "matt.tester@mattthetester.com" in the Contact Email field
    And I enter "888-888-8888" in the Contact Phone field
    And I select the company name as "Clarity" in the Contact Company select list
    And I select role as "General IT Resource" in the Support Role select list
    And I select the value as "Yes" in the Display Contact on Home Page select list
    When I click on the Create Contact - Cancel element button
    Then I am on Manage Contacts List page
    And I sort the Manage Contacts table by the CONTACT NAME column
    And the following Manage Contacts row content in this scenario will be correct
      | SUPPORT ROLE         | CONTACT COMPANY  | CONTACT NAME       | CONTACT EMAIL                 | CONTACT PHONE | HOME DISPLAY | ACTIONS       |
      | General IT Resource  | ClarityTestCards | 1111 Matt Tester   | matt.tester@mattthetester.com | 888-888-8888  | Yes           | Edit  Delete |
 	
Scenario: Submit button taken back to Edit and Create Contacts List with new Contact added
   	And I click the Add Contact button
    And I enter "1111 Matt Tester" in the Contact Name field
    And I enter "matt.tester@mattthetester.com" in the Contact Email field
    And I enter "888-888-8888" in the Contact Phone field
    And I select the company name as "Clarity" in the Contact Company select list
    And I select role as "General IT Resource" in the Support Role select list
    And I select the value as "Yes" in the Display Contact on Home Page select list
    And I click the Create Contact save button
     Then I am on Manage Contacts List page
    And I sort the Manage Contacts table by the CONTACT NAME column
    And the following Manage Contacts row content in this scenario will be correct
      | SUPPORT ROLE        | CONTACT COMPANY  | CONTACT NAME     | CONTACT EMAIL                 | CONTACT PHONE | HOME DISPLAY | ACTIONS     |
      | General IT Resource |  ClarityTestCards| 1111 Matt Tester | matt.tester@mattthetester.com | 888-888-8888  | Yes          | Edit Delete |

Scenario: Edit Contact - validate information brought over
  And I sort the Manage Contacts table by the CONTACT NAME column
  When I select the Manage Contact - Edit action element
  And the following Edit Contacts row content will be correct
  | CONTACT NAME        | CONTACT EMAIL       | CONTACT PHONE        | CONTACT COMPANY    | SUPPORT ROLE  | Display Contact on Home Page |New Support Role Name| 
  | ZZZ1134Name         | 1134@clarityssi.com | 111-111-1134         | ClarityTestCards   | New           | No                           | Day to day          |	
  
 Scenario: Edit Contact - update successful
    And I sort the Manage Contacts table by the CONTACT NAME column
    When I select the Manage Contact - Edit action
	And I click the Create Contact save button
    Then I am on the Manage Contacts List page
    And I sort the Manage Contacts table by the CONTACT NAME column
    And the following Manage Contacts row content in this scenario will be correct
     | SUPPORT ROLE        | CONTACT COMPANY  | CONTACT NAME         | CONTACT EMAIL                 | CONTACT PHONE | HOME DISPLAY | ACTIONS     |
     | General IT Resource | ClarityTestCards | 1111 Matt Tester     | matt.tester@mattthetester.com | 888-888-8888  | Yes          | Edit Delete |

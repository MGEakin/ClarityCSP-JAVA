@combined_pdfs @combined_pdfs_list 
Feature: Combined PDFs 
	SCR_080 Combined PDFs

  BUSINESS RULE: Clarity only does these for Cards

Scenario: 
	Given I log into the Clarity Service Portal 
	And I navigate to the Combined PDFs Page 
		
	#    TABLE SECTION
	
@smoke_test 
Scenario: Validate Combined PDFs list table column headers 
	Then the Combined PDFs List table will have the correct column <column_name> headers 
	# | column_name       |
		| REQUEST DATE          |
		| DESCRIPTION          |
		| AUTHOR    |
		| STATUS   |
		| RESULTS            |
		| ACTIONS       |
		
 
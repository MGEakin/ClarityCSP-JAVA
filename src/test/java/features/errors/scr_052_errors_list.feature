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
	
#    HEADERS SECTION
  Scenario: Validate page title
	Then I am on the Errors List page
	
#    PAGINATION SECTION
  Scenario: Validate Items per page selection count
    And the Page Count display list will contain
      | 20         |
      | 50         |
      | 100        |
     
 Scenario: Validate Items per page default value is 20
	Then the default Page Count selection is "20"
	
Scenario: Validate Items per page - select will cause page refresh
    When I select "50" in the Page Count select list
    Then the Errors result page count will be as expected
    When I select "100" in the Page Count select list
    Then the Errors result page count will be as expected
    When I select "20" in the Page Count select list
	Then the Errors result page count will be as expected


 # THE FOLLOWING TEST IS BEING INDIRECTLY TESTED IN OTHER TESTS
  # KEPT IN TO ALIGN WITH MASTER LIST TEST CASES
  Scenario: click on Search button invokes Popup search windown
    When I click the Errors - View Report button
	Then I am on View Report Window page
	
# THE FOLLOWING TEST IS BEING INDIRECTLY TESTED IN OTHER TESTS
#  KEPT IN TO ALIGN WITH MASTER LIST TEST CASES
  Scenario: click on Add Error button taken to Add Error Page
    When I click the Errors - View File Details button
	Then I am on the File Details page


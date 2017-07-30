@combined_pdfs @combined_pdfs_list 
Feature: Combined PDFs 
	SCR_080 Combined PDFs

  BUSINESS RULE: Clarity only does these for Cards

Scenario:
   Given I log in using a ClarityTestBooks client
 And I navigate to the Combined PDFs Page

	#    TABLE SECTION
	@smoke_test 
Scenario: Validate Combined PDFs list table column headers 
	Then the Combined PDFs List table will have the correct column <column_name> headers 
	# | column_name       |
		| REQUEST DATE    |
		| DESCRIPTION          |
		| AUTHOR    |
		| STATUS   |
		| RESULTS            |
		| ACTIONS       |
		
@smoke_test
Scenario: Validate result count of Combined PDFs against API count
Then the Combined PDFs result count will be as expected

#    HEADERS SECTION
  Scenario: Validate page title
	Then I am on the page Combined PDFs List page

Scenario: click on Refresh button refreshes windown
    When I click the "Combined PDF - Refresh" button
Then I am on the Combined PDFs List page

#    PAGINATION SECTION
  Scenario: Validate Items per page selection count
    And the combined_pdf_list page count display list will contain
      | 20         |
      | 50         |
      | 100        |
      
Scenario: Validate Items per page default value is 20
Then the default page in combined_PDfs selection is "20"

@this_one
  Scenario: Validate Items per page - select will cause page refresh
    When I select "50" in the Pagination - CombinedPDFs select list
    Then the CombinedPDFs result count will be as expected
    When I select "100" in the Pagination - CombinedPDFs select list
    Then the CombinedPDFs result count will be as expected
    When I select "20" in the Pagination - CombinedPDFs select list
	Then the CombinedPDFs result count will be as expected

@this_one
  Scenario: Validate Items per page - select will cause page refresh - validate against API returns
    When I select the page count as "50" in the Pagination - CombinedPDFs select list
    Then the CombinedPDFs result count in API will be as expected
    When I select the page count as "100" in the Pagination - CombinedPDFs select list
    Then the CombinedPDFs result count in API will be as expected
    When I select the page count as "20" in the Pagination - CombinedPDFs select list
	Then the CombinedPDFs result count in API will be as expected
	
#  THE FOLLOWING TEST IS BEING INDIRECTLY TESTED IN OTHER TESTS
#  KEPT IN TO ALIGN WITH MASTER LIST TEST CASES
  Scenario: click on Add Request button taken to SCR_081 Request a Combined PDF
    When I click the Add Request "Combined PDF - Add Request" button
Then I am on the Request a Combined PDF page

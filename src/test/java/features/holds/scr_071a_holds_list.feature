@holds @holds_list
Feature: Holds List
  31.1 SCR_071a Holds (List)

  Scenario: 
    Given I log into the Clarity Service Portal
    And I navigate to the Holds Page
    And I am on the Holds List page

#    HEADERS SECTION
  Scenario: Validate page title
    Then I am on the Holds List page

#  THE FOLLOWING TEST IS BEING INDIRECTLY TESTED IN OTHER TESTS
#  KEPT IN TO ALIGN WITH MASTER LIST TEST CASES
  Scenario: click on Search button invokes Popup search windown
    When I click the Holds - Search button
    Then I am on the Holds Search page

#  THE FOLLOWING TEST IS BEING INDIRECTLY TESTED IN OTHER TESTS
#  KEPT IN TO ALIGN WITH MASTER LIST TEST CASES
  Scenario: click on Add Hold button taken to Add Hold Page
    When I click the Hold - Add button
    Then I am on the Add Hold page

#  THE FOLLOWING TEST IS BEING INDIRECTLY TESTED IN OTHER TESTS
#  KEPT IN TO ALIGN WITH MASTER LIST TEST CASES
  Scenario: Validate filters for the hold List
    And the holds status display list will contain
      #| list_item         |
      | All               |
      | Unresolved        |
      | Recently Resolved |
      | Mine              |

  Scenario: Validate status filter default value is Unresolved
    Then the default Holds status selection is "Unresolved"

  # Scenario Outline: Validate result count of holds against API count
  #   When I select "<display_select>" in the Holds List Status select list
  #  Then the holds result count will be as expected
  #  Examples:
  #   | display_select    |
  #  | Unresolved        |
  # | Recently resolved |
  # | Mine              |
  # | All               |
  Scenario: ALL filter the hold List and get correct results
    When I select "All" in the Holds List Status select list
    Then the following holds row content will be correct
      | HOLDS ID | CRITERIA                | EFFECTIVE DATE | EXPIRATION DATE | AUTHOR      | HELD ORDERS | STATUS   | HOLD REASON   | RESOLUTION REASON            |
      |        1 | FAMILY_ID equal 1030299 | 03/02/2017     | 03/31/2017      | npisani_all |           6 | Approved | Design Change | Management Approval Required |

  # Scenario: Ability to ALL filter the hold List and get correct results - validate API return
  #  When I select "All" in the Holds List Status select list
  #Then the holds row content will match the API results
  
  Scenario: Unresolved filter the hold List and get correct results
    When I select "Unresolved" in the Holds List Status select list
    Then the following holds row content will be correct
      | HOLDS ID | CRITERIA           | EFFECTIVE DATE | EXPIRATION DATE | AUTHOR | HELD ORDERS | STATUS     | HOLD REASON    | RESOLUTION REASON |
      |        6 | PLAN_ID equal test | 02/01/2018     | 02/14/2018      | fdsa   |           0 | Unresolved | Internal Audit |                   |

  # Scenario: Ability to Unresolved filter the hold List and get correct results - validate API return
  #  When I select "Unresolved" in the Holds List Status select list
  # Then the holds row content will match the API results
  
  Scenario: Rejected filter the hold List and get correct results
    When I select "Recently Resolved" in the Holds List Status select list
    Then the following holds row content will be correct
      | HOLDS ID | CRITERIA                | EFFECTIVE DATE | EXPIRATION DATE | AUTHOR      | HELD ORDERS | STATUS   | HOLD REASON   | RESOLUTION REASON            |
      |        1 | FAMILY_ID equal 1030299 | 03/02/2017     | 03/31/2017      | npisani_all |           6 | Approved | Design Change | Management Approval Required |

  # Scenario: Ability to Rejected filter the hold List and get correct results - validate API return
  #   When I select "Recently resolved" in the Holds List Status select list
  #  Then the holds row content will match the API results
  Scenario: Cancelled filter the hold List and get correct results
    When I select "Mine" in the Holds List Status select list
    Then the following holds row content will be correct
      | HOLDS ID | CRITERIA                | EFFECTIVE DATE | EXPIRATION DATE | AUTHOR      | HELD ORDERS | STATUS   | HOLD REASON   | RESOLUTION REASON            |
      |        1 | FAMILY_ID equal 1030299 | 03/02/2017     | 03/31/2017      | npisani_all |           6 | Approved | Design Change | Management Approval Required |

  #Scenario: Ability to Cancelled filter the hold List and get correct results - validate API return
  # When I select "Mine" in the Holds List Status select list
  #Then the holds row content will match the API results
  Scenario: Breadcrumb of current filter applieds
    When I select "All" in the Holds List Status select list
    When I search Holds by HOLDS ID with a value of "9"
    Then I see the text "HOLD ID: 9" on the screen

  # @smoke_test
  #Scenario: Validate result count of Holds against API count
  # When I select "All" in the Holds List Status select list
  #Then the Holds result count will be as expected
  #    TABLE SECTION
  @smoke_test
  Scenario: Validate holds list table column headers
    Then the Holds List table will have the correct column <column_name> headers
      #   | column_name       |
      | HOLDS ID          |
      | CRITERIA          |
      | EFFECTIVE DATE    |
      | EXPIRATION DATE   |
      | AUTHOR            |
      | HELD ORDERS       |
      | STATUS            |
      | HOLD REASON       |
      | RESOLUTION REASON |
      | ACTIONS           |

  #Scenario Outline: Sort table by any column - validate against API returns
  #  When I select "All" in the Holds List Status select list
  # When I sort the Holds table by the <column_name> columns
  #Then the Holds row content will match the API results
  Scenario: Validate Holds List content is correct
    When I select "All" in the Holds List Status select list
    When I search Holds by HOLDS ID with a value of "9"
    Then the following holds row content will be correct
      | HOLDS ID | CRITERIA           | EFFECTIVE DATE | EXPIRATION DATE | AUTHOR       | HELD ORDERS | STATUS    | HOLD REASON    | RESOLUTION REASON |
      | 9        | PLAN_ID equal test | 02/01/2018     | 02/01/2025      | someUsername | 0           | Cancelled | Internal Audit |                   |

  Scenario: Validate Hold ID link taken to Hold Details page
    When I select "All" in the Holds List Status select list
    When I select the Holds ID of the first record displayed
    Then I am on the Hold Details page

########## Completed scenarios before this line ##
  Scenario: Action - Details taken to Hold Details page
    When I select "All" in the Holds List Status select list
    And I search Holds by HOLDS ID with a value of "12114"
    When I select the Details option from the Gears dropdown
    Then I am on the Hold Details page

  Scenario: Action - Approve Hold page - via Gears dropdown
    When I select "All" in the Holds List Status select list
    And I search Holds by HOLDS ID with a value of "12114"
    When I select the Approve option from the Gears dropdown
    Then I am on the Approve Hold page

  Scenario: Action - Reject Hold page - via Gears dropdown
    When I select "All" in the Holds List Status select list
    And I search Holds by HOLDS ID with a value of "12114"
    When I select the Reject option from the Gears dropdown
    Then I am on the Reject Hold page

  Scenario: Action - Duplicate Hold page - via Gears dropdown
    When I select "All" in the Holds List Status select list
    And I search Holds by HOLDS ID with a value of "12114"
    When I select the Duplicate option from the Gears dropdown
    Then I am on the Add Hold page
Scenario: Action - Duplicate - validate information brought over
    When I select "All" in the Holds List Status select list
    And I search Holds by Holds ID with a value of "12114"
    When I select the Duplicate option from the Gears dropdown
    And the following Add Hold row content will be correct
      | CRITERIA              | EFFECTIVE DATE | EXPIRATION DATE | AUTHOR      | HELD ORDERS | STATUS   | HOLD REASON   | RESOLUTION REASON            |
      | GROUP_ID equal 343456 | 05/24/2017     | 05/31/2017      | julie_m_all | 5330        | Approved | Design Change | Management Approval Required |

  Scenario: Action - Duplicate - successful duplicate
    And I select "All" in the Holds List Status select list
    And I search Holds by Holds ID with a value of "12114"
    When I select the Duplicate option from the Gears dropdown
    When I enter "01/31/2018" in the EFFECTIVE DATE field
    When I enter "01/31/2025" in the EXPIRATION DATE field
    And I click the "Add Hold - Save" button
    And I am on the Holds List page
    And I select "All" in the Holds List Status select list
    And I sort the Holds table by the HOLDS ID column
    And I sort the Holds table by the HOLDS ID column
    Then the following holds row content will be correct
      | CRITERIA              | EFFECTIVE DATE | EXPIRATION DATE | STATUS     | HOLD REASON   |
      | GROUP_ID equal 343456 | 01/31/2018     | 01/31/2025      | Unresolved | Design Change |

#    THESE NEXT FEW TESTS CANNOT BE BUILT AS THERE IS NO DATA SUPPORTING THEM
#  @wip
#  Scenario: Action - Remove a Hold - Validate warning message - via Gears dropdown
#    And I search Holds by Hold ID with a value of "2142"
#    When I select the Remove option from the Gears dropdown
#    Then I see the text "Are you sure you want to remove this hold?" on the screen
#
#  @wip
#  Scenario: Action - Remove a Hold - Cancel
#    And I search Holds by Hold ID with a value of "2142"
#    When I select the Remove option from the Gears dropdown
#    And I click the "Remove Hold - Cancel" button
#    Then the Holds row content will match the API results
#
#  @wip
#  Scenario: Action - Remove a Hold - OK
#    And I search Holds by Hold ID with a value of "2142"
#    When I select the Remove option from the Gears dropdown
#    And I click the "Remove Hold - OK" button
#    And I select the Cancelled Hold status display option
#    Then the Holds row content will match the API results

#    PAGINATION SECTION
  Scenario: Validate Items per page selection count
    And the holds list page count display list will contain
      | page_count |
      | 20         |
      | 50         |
      | 100        |

  Scenario: Validate Items per page default value is 20
    Then the default page selection is "20"

  Scenario: Validate Items per page - select will cause page refresh
    When I select "All" in the Holds List Status select list
    When I select "50" in the Pagination - Holds select list
    Then the Holds result count will be as expected
    When I select "100" in the Pagination - Holds select list
    Then the Holds result count will be as expected
    When I select "20" in the Pagination - Holds select list
    Then the Holds result count will be as expected

  Scenario: Validate Items per page - select will cause page refresh - validate against API returns
    When I select "All" in the Holds List Status select list
    When I select "50" in the Pagination - Holds select list
    Then the Holds result count will be as expected
    When I select "100" in the Pagination - Holds select list
    Then the Holds result count will be as expected
    When I select "20" in the Pagination - Holds select list
    Then the Holds result count will be as expected

  Scenario: Validate Holds List pagination controls - Forward arrow
    When I select "All" in the Holds List Status select list
    When I click the Forward Pagination arrow
    Then the Holds result count will be as expected

  Scenario: Validate Holds List pagination controls - Forward arrow - validate against API returns
    When I select "All" in the Holds List Status select list
    When I click the Forward Pagination arrow
    Then the Holds result count will be as expected

  Scenario: Validate Holds List pagination controls - Backward arrow
    When I select "All" in the Holds List Status select list
    And I click the Forward Pagination arrow
    When I click the Backward Pagination arrow
    Then the Holds result count will be as expected

  Scenario: Validate Holds List pagination controls - Backward arrow - validate against API returns
    When I select "All" in the Holds List Status select list
    And I click the Forward Pagination arrow
    When I click the Backward Pagination arrow
    Then the Holds result count will be as expected

  Scenario: Validate Holds List pagination controls - select Page 2
    When I select "All" in the Holds List Status select list
    When I navigate to Holds Page 2
    Then the Holds result count will be as expected

  Scenario: Validate Holds List pagination controls - select Page 2 - validate against API returns
    When I select "All" in the Holds List Status select list
    When I navigate to Holds Page 2
    Then the Holds result count will be as expected

  Scenario: Validate Holds List pagination controls - back to page 1
    When I select "All" in the Holds List Status select list
    When I navigate to Holds Page 2
    Then I navigate to Holds Page 1
    Then the Holds result count will be as expected

  Scenario: Validate Holds List pagination controls - back to page 1 - validate against API returns
    When I select "All" in the Holds List Status select list
    When I navigate to Holds Page 2
    Then I navigate to Holds Page 1
    Then the Holds result count will be as expected

  Scenario: Validate Pagination Page 1 highlighted on default
    Then Holds Page number 1 will be highlighted
    When I navigate to Holds Page 2
    Then Holds Page number 2 will be highlighted
    Then I navigate to Holds Page 1
    Then Holds Page number 1 will be highlighted
    
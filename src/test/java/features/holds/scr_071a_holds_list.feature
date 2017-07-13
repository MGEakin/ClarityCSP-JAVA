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
      |  12208   | FAMILY_ID equal 111231112300 |  07/07/2017 | 07/28/2017|  268    |           0 | Unresolved | First Review |                   |

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
      | HOLDS ID | CRITERIA                | EFFECTIVE DATE | EXPIRATION DATE | AUTHOR   | HELD ORDERS | STATUS   | HOLD REASON   | RESOLUTION REASON            |
      |     8528 | PLAN_ID not equal Sample Value | 05/01/2017  | 05/13/2017  |  268     |       1096  | Approved | Design Change |  Verified Cost Sharing       |

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
      | 1        | FAMILY_ID equal 1030299 | 03/02/2017     | 03/31/2017      | npisani_all | 6         | Approved | Design Change |  Management Approval Required |

  Scenario: Validate Hold ID link taken to Hold Details page
    When I select "All" in the Holds List Status select list
    When I select the Holds ID of the first record displayed
    Then I am on the Hold Details page

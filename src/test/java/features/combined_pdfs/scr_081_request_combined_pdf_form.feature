Feature: Request Combined PDF (Form)
  SCR_081 Request Combined PDF (Form)

  BUSINESS RULE: Clarity only does these for Cards

  Scenario:
	Given I log in using a ClarityTestBooks client 
    And I navigate to Combined PDFs Page
    And I click the Combined PDF - Add Request button
    And I am on Request a Combined PDF page

    Scenario: Request a Combined PDF by JOB ID
    When I enter "759223" in the Combined PDF - JOB ID field
    And I click the Request Combined PDF - SUBMIT button
    Then the following Combined PDFs row content will be correct
     
      | REQUEST DATE | DESCRIPTION     | AUTHOR  | STATUS  | RESULTS |ACTIONS |
      | 08/02/2017   | Job ID = 759223 | 268     |pending  |         |        |
      
   Scenario: Request a Combined PDF by PRINT ID
    When I enter "1164638" in the Combined PDF - PRINT ID field
    And I click the Request Combined PDF - SUBMIT button
    Then the following Combined PDFs row content will be correct
      | REQUEST DATE | DESCRIPTION        | AUTHOR |STATUS  | RESULTS | ACTIONS |
      | 08/02/2017   | Print ID = 1164638 | 268    |pending |         |         |
      
   @dates
 Scenario: Request a Combined PDF by PROCESSED DATE
    When I enter "Date Range,06/01/2017,06/01/2025" in the Combined PDF - PROCESSED DATE field
    And I click the Request Combined PDF - SUBMIT button
    Then the following Combined PDFs row content will be correct
      | REQUEST DATE | DESCRIPTION                                    | AUTHOR | STATUS  |RESULTS  | ACTIONS |
      | 08/02/2017   | Processed Date from Jun 1, 2017 to Jun 1, 2025 | 268    | pending |         |         |
      
 Scenario: Request a Combined PDF by GROUP ID
    When I enter "343456" in the Combined PDF - GROUP ID field
    And I click the Request Combined PDF - SUBMIT button
    Then the following Combined PDFs row content will be correct
      | REQUEST DATE | DESCRIPTION       | AUTHOR | STATUS  | RESULTS | ACTIONS |
      | 08/02/2017   | Group ID = 343456 | 268    | pending |         |         |
      
 Scenario: Request a Combined PDF by PLAN ID
    When I enter "987654321" in the Combined PDF - PLAN ID field
    And I click the Request Combined PDF - SUBMIT button
    Then the following Combined PDFs row content will be correct
      | REQUEST DATE | DESCRIPTION         | AUTHOR | STATUS  |RESULTS  | ACTIONS |
      | 08/02/2017   | Plan ID = 987654321 | 268    | pending |         |         |
      
 Scenario: Request a Combined PDF by multiple: JOB ID + GROUP ID
    When I enter "759223" in the Combined PDF - JOB ID field
    When I enter "343456" in the Combined PDF - GROUP ID field
    And I click the Request Combined PDF - SUBMIT button
    Then the following Combined PDFs row content will be correct
      | REQUEST DATE | DESCRIPTION                           | AUTHOR |STATUS  | RESULTS  |ACTIONS |
      | 08/02/2017   | Job ID = 759223 and Group ID = 343456 | 268    |pending |          |        |
      
      
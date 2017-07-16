@sample_orders @sample_orders_list
Feature: Sample Orders (LIST)
  SCR_098a Sample Orders (LIST)

  Scenario:
    Given I log into the Clarity Service Portal
    And I navigate to the Sample Orders Page


  @smoke_test
  Scenario: Validate Sample Orders list table column headers
    Then the Sample Orders List table will have the correct column <column_name> headers
    #| column_name       |
      | SAMPLE ORDER NAME |
      | TYPE              |
      | ADDRESS BOOK      |
      | SUBMIT DATE       |
      | AUTHOR            |
      | RUN DATE          |
      | JOB ID            |
      | DESIGN TYPE       |
      | MAIL TYPE         |
      | CARRIER           |
      | SHIP METHOD       |
  
  

@smoke_test
Scenario: Validate result count of Sample Orders Type against API count
When I sort the Sample Orders table by the SAMPLE ORDER NAME column
Then the Sample Orders result count will be as expected 

@smoke_test
Scenario: Validate result count of Address against API count
Then the Address Books result count will be as expected

@smoke_test
Scenario: Validate Address list table column headers
Then the Address Books List table will have the correct column <column_name> headers
|NAME|
|DATE MODIFIED|
|DESCRIPTION| 
|ACTIONS|


 
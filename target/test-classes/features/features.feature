
Feature: getNotices Testing

Scenario Outline: Validating getNotices with valid credential.
Given I am at the login page
When I enter by "<MEMBER_NAME>"
And I provide by "<USER_ID>" 
And I give by "<GROUPNAME>"
And Click on Submit "<button>"
Then I should be on Homepage
When I click on Hello "<link>"
Then I will reach admin page
When I Click on the "<Notice_Message_Link>"
Then I should be Message Notice Page
And I see Main Title "<MainTitle>"
When Display filter has Value_Array_to_check
And Results shows "<Result_string_to_check>"
And Table has columns
And Items per page shows "<value>"
And I see buttons "<button1>" and "<button2>"

Examples:
|MEMBER_NAME|USER_ID|GROUPNAME|button|link|Notice_Message Link|MainTitle|Result_string_to_check|value|button1|button2| 
| Ashwa|ash22|claritytestcards, TestCardsOperation|loginbtn|nav_salutation|landing-files|Manage Notice Messages|All|50|pager_next_page|addNoticeButton||











@smoke
@ilhan
@B7KCLS-105
Feature:As a user I should be able to register on the website
   @B7KCLS-120
  Scenario: The user can make register with valid credentials
    Given The user on the register page
    When The user enter valid credential
    Then The user can make register

   @B7KCLS-121
  Scenario Outline: The user can not make register with invalid credentials
    Given The user on the register page
    When The user enter invalid  "<firstName>","<lastName>","<eMail>","<password1>","<password2>" credential
    Then The user can not make register and see "<warnung>" message
    Examples:
      | firstName | lastName | eMail             | password1 | password2 | warnung        |
      |           | Stone    | abc1234@gmail.com | Test1234  | Test1234  | obligatorisch! |
      | Jack      |          | abc1235@gmail.com | Test1234  | Test1234  | obligatorisch! |
      | Jack      | Stone    |                   | Test1234  | Test1234  | required       |
      | Jack      | Stone    | abc1234@gmail.com |           | Test1234  | erforderlich   |
      | Jack      | Stone    | abc1234@gmail.com | Test1234  |           | erforderlich   |










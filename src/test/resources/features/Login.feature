@smoke
@B7KCLS-106

Feature: User Login Functionality - I should be able to login with valid credential

  Scenario: Login with username and password (!! This Scenario is for common usage !!)
    Given The user is logging in with valid credentials

  @B7KCLS-115
  Scenario: Verify that I can log in by entering the correct information
    Given The user click on the Mein Konto
    Then The user click on the Anmelden
    Then The user enter the correct E-mail und Password
    When The user click the Anmelden button after entering the correct E-Mail and Password
    Then The user should be successfully logged in

  @B7KCLS-116
  Scenario Outline: Verify error message is displayed when I enter one or both Email and Password incorrectly
    Given The user click on the Mein Konto
    Then The user click on the Anmelden
    When The user enters one or both of "<Email>" and "<Password>" incorrectly
    Then The user should get an error Message, when the user enters the incorrect E-Mail or Password
    Examples:
      | Email                         | Password            |
      | kaclassictestteam@gmail.      | 123456              |
      | kaclassictestteam@gmail.com   | 13579abcde          |
      | kaclassictestteam@gmail.com   | asklas              |
      | kaclassictestteam@gmail.com   | *#*#                |
      | kaclassictestteam@gmail.com   | *kaclassic          |
      | @gmail.com                    | kaclassictestteam   |
      | kaclassictestteamgmail.com    | *kaclassictestteam# |
      | kaclassictestteam@hotmail.com | *kaclassictestteam# |
      | @gmail.com                    | *kaclassictestteam# |

  @B7KCLS-117
  Scenario Outline: Verify that the error message is displayed when I do not fill in the required field
    Given The user click on the Mein Konto
    Then The user click on the Anmelden
    When The user leaves one or both of the "<EMail>" and "<Password>" fields blank
    Then The user should get an error Message, when the user leaves one or both of the email and password fields blank
    Examples:
      | EMail                       | Password            |
      | kaclassictestteam@gmail.com |                     |
      |                             | *kaclassictestteam# |
      |                             |                     |
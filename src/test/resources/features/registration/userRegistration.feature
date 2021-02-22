Feature: Feature to validate creating a new account

  Scenario Outline: User is able to enter their own information and create a new account
    Given User is on the CrowdStreet home page
    And   User is able to click on the "CREATE AN ACCOUNT" button
    When  User enters their personal information and complete the registration form
    And   User clicks on the "SIGN UP" button
    Then  User should see that popup that says "Congrats," followed by their "<FirstName>"
    Examples:
      | FirstName |
      |   USER    |

    Scenario: Users should be able to login with their information
      Given User is on the CrowdStreet home page
      And   User is able to click on "SIGN IN" button
      When  User enters their personal information in the sign in page
      And   User clicks on "LOG IN NOW" button
      Then  User should see an account section on the top right of the page that says "HI " followed by their firstName


Feature: Authentication
Logging in as customer

  Scenario: Successfully logging in
    Given the Bata login page
    When logging in as customer
    Then the home page navigation is available
Feature: Techfiols billing login page functionality validation

 Scenario: Usershould be able to login with valid credentials
    Given User is on the techfios login page
    When User enters username as "demo@techfios.com"
    When User enter passward as "abc123"
    When User click on sign in button
    Then User land on dashboard page 



  Scenario: Usershould not be able to login with valid credentials
    Given User is on the techfios login page
    When User enters username as "demo2@techfios.com"
    When User enter passward as "abc123"
    When User click on sign in button
    Then User land on dashboard page 

    Scenario: Usershould be able to login with valid credentials
    Given User is on the techfios login page
    When User enters username as "demo@techfios.com"
    When User enter passward as "abc123"
    When User click on sign in button
    Then User land on dashboard page 
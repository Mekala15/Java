Feature: Opening the Browser

  Scenario: Open the Page
    Given Open the Chrome
    When Enter the URL
    And Navigate to Link
    And Page is Displayed
    And Check the Title
    And Navigate to Link1
    Then Retrive the Elements

Feature: Test cases for jysk.pl

  Scenario: Search query
    Given User is on the HomePage
    When User enters "Krzesła" and click search button
    Then Search result equals to expected result
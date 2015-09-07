Feature: Calculator

  The calculator takes a String containing a comma-separated list of integers and builds the sum of these integers.

  Scenario: The sum of nothing
    Given an empty String
    When passing it to the calculator
    Then the result is 0

  Scenario: Sum up three numbers
    Given the String "1,3,0"
    When passing it to the calculator
    Then the result is 4

  Scenario Outline: More sums
    Given the String "<input>"
    When passing it to the calculator
    Then the result is <output>
    Examples:
      | input               | output |
      | 1                   | 1      |
      | 1,1                 | 2      |
      | 1,2                 | 3      |
      | 1,2,3,4             | 10     |
      | 1000,2000,3000,4000 | 10000  |

Feature: Get booking

  Scenario Outline:Retrieve booking details with a valid ID
    Given The user has valid "<ID>"
    When The user send GET request to get booking endpoint with specific ID as 2
    Then The user should see status code as <status code>
    Examples:
      | ID | status code |
      | 2  | 200         |
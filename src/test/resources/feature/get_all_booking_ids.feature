Feature: Get All Booking Ids

  Scenario Outline:
    Given The user in the base URI
    When the user send GET request to get all bookings endpoint
    Then The user should see status code as <status code>
    And The user should see array of bookings
    Examples:
      | status code |
      | 200         |
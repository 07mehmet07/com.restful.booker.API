Feature: Delete booking

  Scenario: Validate delete booking functionality with authorization
    Given The user in the base URI
    When The user sends a DELETE request to the delete booking endpoint with valid id 5209
    Then The user should see status code as 204

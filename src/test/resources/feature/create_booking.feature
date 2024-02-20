Feature:Create Booking
  Scenario: Create a new booking with valid details
    Given The user in the base URI
    When the user send POST request to the endpoint with following details
      | firstname       | mehmet     |
      | lastname        | aykut      |
      | totalprice      | 500        |
      | depositpaid     | true       |
      | checkin         | 2023-01-01 |
      | checkout        | 2024-01-01 |
      | additionalneeds | Breakfast  |
    Then The user should see status code as 200
    And The booking id should not be empty or null
    And The booking object in response should match with given datas
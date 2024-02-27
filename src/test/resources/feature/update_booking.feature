Feature:Update Booking
  Scenario: Update booking with valid details
    Given The user in the base URI
    When the user send Update request to the endpoint with following details
      | firstname       | Taha       |
      | lastname        | furkan     |
      | totalprice      | 400        |
      | depositpaid     | true       |
      | checkin         | 2023-01-01 |
      | checkout        | 2024-01-01 |
      | additionalneeds | Breakfast  |
    Then The user should see status code as 200
    And The booking objects in response should match with given datas
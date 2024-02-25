Feature: User Login

  Scenario Outline: Successfully create an auth token
    Given The user has valid "<username>" and "<password>"
    When The user send POST request to the login endpoint
    Then The user should see status code as <status code>
    And The user receives a token as a response
    Examples:
      | username | password    | status code |
      | admin    | password123 | 200         |

  Scenario Outline: Unsuccessfully create an auth token
    Given The user has invalid "<username>" and valid "<password>"
    When The user send POST request to the login endpoint
    Then The user should see status code as <status code>
    And The response should contain an "<error message>"
    Examples:
      | username | password    | status code | error message   |
      | 1516     | password123 | 400         | Bad credentials |
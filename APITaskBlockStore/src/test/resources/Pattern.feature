Feature: Get request to colourLovers
  Scenario Outline: Post pattern Login
    Given The user calls Post Pattern PathParameter "auth/login" successfully and User enter "<username>" and "<password>"
    Then Check returned "<statusCode>"
    Examples:
      | username   | password | statusCode |
      | kminchelle | 0lelplR  | 200        |
      | 0lelplR    | 0lelplR  | 400        |
      | null       | null     | 400        |
      |            |          | 400        |
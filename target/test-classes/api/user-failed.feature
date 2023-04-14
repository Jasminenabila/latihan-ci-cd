Feature: User
  As an admin
  I want to see api jsonplaceholder negatif case
  So that I check negatif user

  Scenario: GET Negative Case - As admin user have be able to get list user, but can't be access
    Given user set GET endpoints failed
    When user send GET HTTP request
    Then user receive valid HTTP response code 404
    And user receive invalid data

  Scenario: Get Negative Case - As admin user have be able to get detail user, but can't be access
    Given user set GET endpoints get data with id is failed
    When user send GET HTTP request is failed
    Then user receive valid HTTP response code 404 is failed
    And user receive invalid data is failed

  Scenario: Post Negative Case - As admin user have be able to submit post user with url invalid, shouldn't be access
    Given user set POST endpoints invalid submit data is failed
    When user send POST HTTP request submit data is failed
    Then user receive valid data submit post HTTP response code 404 is failed
    And user receive invalid response body should be failed

  Scenario: Put Negative Case - As admin user have be able to update put user with id not found, shouldn't be access
    Given user set PUT endpoints invalid userid not found is failed
    When user send PUT HTTP request update userid not found is failed
    Then user receive internal server error HTTP response code 500 is failed

  Scenario: Put Negative Case - As admin user have be able to update put user with id not found, shouldn't be access
    Given user set PUT endpoints invalid userid not found is failed
    When user send PUT HTTP request update userid not found is failed
    Then user receive internal server error HTTP response code 500 is failed

  Scenario: Delete Negative Case - As admin user have be able to delete user with with url invalid, shouldn't be access
    Given user set DELETE endpoints invalid url is failed
    When user send DELETE HTTP request invalid url is failed
    Then user receive response HTTP response code 404 method DELETE is failed
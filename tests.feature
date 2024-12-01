Feature: Client Application Message Sending

  Scenario: Send a message to the server
    Given the client application is running
    When I enter "Hello, Server!" into the input field
    And I click the send button
    Then I should see "200 OK -> Processed: Hello, Server!" in the result label

  Scenario: Send an empty message to the server
    Given the client application is running
    When I click the send button without entering a message
    Then I should see "200 OK -> Processed: " in the result label

  Scenario: Send a message with special characters to the server
    Given the client application is running
    When I enter "!@#$%^&*()" into the input field
    And I click the send button
    Then I should see "200 OK -> Processed: !@#$%^&*()" in the result label

  Scenario: Send a very long message to the server
    Given the client application is running
    When I enter "aaaaaaaaaa" into the input field
    And I click the send button
    Then I should see "200 OK -> Processed: aaaaaaaaaa" in the result label

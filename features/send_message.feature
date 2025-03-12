Feature: Client Application Message Sending

  Scenario: Send a message to the server
    Given the client application is running
    When I enter "Hello, Server!" into the input field
    And I click the send button
    Then I should see "200 OK -> Processed: Hello, Server!" in the result label

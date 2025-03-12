Feature: Client Application Message Sending

  Scenario: Send an empty message to the server
    Given the client application is running
    When I click the send button without entering a message
    Then I should see "200 OK -> Processed: " in the result label

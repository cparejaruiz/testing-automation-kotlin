Feature: Client Application Message Sending

  Scenario: Send a message with special characters to the server
    Given the client application is running
    When I enter "!@#$%^&*()" into the input field
    And I click the send button
    Then I should see "200 OK -> Processed: !@#$%^&*()" in the result label

Feature: Client Application Message Sending

  Scenario: Send a very long message to the server
    Given the client application is running
    When I enter "aaaaaaaaaa" into the input field
    And I click the send button
    Then I should see "200 OK -> Processed: aaaaaaaaaa" in the result label

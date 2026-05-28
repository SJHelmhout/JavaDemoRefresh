Feature: Person API Functionality
    As a user
    I want to retrieve person details
    So that I can verify the system data

  Scenario: Successfully get a JSON person
      When I request the json person endpoint
      Then the response should contain the name "Annette"
Feature: Validating creation of new application For QA Engineer


   Background: User submit application for QA Engineer
   Given User accept the cookies

    Scenario: Verify creation of new application for QA position
        Given User clicks on apply button
        When User enters application details
        Then I validate the confirmation message
      
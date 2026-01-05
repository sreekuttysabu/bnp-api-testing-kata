Feature: Booking API

  Scenario: Verify successful booking creation using complete and accurate information
  Given a complete and valid set of booking details
  When  I submit the request to create a new booking
  Then  the response status code should be 201
  And   provide a unique booking identifier in the response
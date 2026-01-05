
@booking
Feature: Booking API

 Scenario: Verify successful booking creation using complete and accurate information
  Given a complete and valid set of booking details
  When  I submit the request to create a new booking
  Then  the response status code should be 201
  And   provide a unique booking identifier in the response 
  
  Scenario: Validation check for invalid phone number
  Given a booking payload with invalid phone number
  When I create a booking
  Then the response status code should be 400
  And an error message should be returned
  
  Scenario: Verify that error throws when last name is omitted
  Given a booking payload without last name
  When I create a booking
  Then the response status code should be 400
  And an error message should be returned
  
  Scenario: Verify that user  still able to Create booking without deposit
  Given a valid booking payload without deposit
  When I create a booking
  Then the response status code should be 201
  And provide a unique booking identifier in the response
  
  Scenario: verify user can  update booking firstname successfully
  Given an existing booking
  And I am authenticated
  When I update the booking firstname
  Then the response status code should be 200
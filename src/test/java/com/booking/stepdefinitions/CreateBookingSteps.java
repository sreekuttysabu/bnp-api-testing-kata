package com.booking.stepdefinitions;



	import io.cucumber.java.en.*;
	import io.restassured.response.Response;

	import static io.restassured.RestAssured.*;
	import static org.junit.Assert.*;

import java.util.Random;

import com.booking.utils.BookingPayloadUtil;

	public class CreateBookingSteps {

	    private Response response;
	    private String booking_Payload;

	    @Given("a complete and valid set of booking details")
	    public void a_complete_and_valid_set_of_booking_details() {
	    	
	    	booking_Payload = BookingPayloadUtil.createBookingPayload(
	                true,
	                "12345678901"
	        );
	    }

	    @When("I submit the request to create a new booking")
	    @When("I create a booking")
	    public void i_submit_the_request_to_create_a_new_booking() {
	    	response = given()
	                .header("Content-Type", "application/json")
	                .accept("application/json")
	                .body(booking_Payload)
	                .when()
	                .post("https://automationintesting.online/api/booking");
	    	
	    	response.then().log().ifValidationFails();
	    }

	    @Then("the response status code should be {int}")
	    public void the_response_status_code_should_be(Integer statusCode) {
	        assertEquals(statusCode.intValue(), response.getStatusCode());
	    }

	    @Then("provide a unique booking identifier in the response")
	    public void provide_a_unique_booking_identifier_in_the_response() {
	        assertNotNull(
	                "Booking id should be available",
	                response.jsonPath().get("bookingid")
	        );
	    }
	    @Given("a booking payload with invalid phone number")
	    public void a_booking_payload_with_invalid_phone_number() {

	    	booking_Payload = BookingPayloadUtil.createBookingPayload(
	                true,
	                "123"
	        );
	    }


	    @Then("an error message should be returned")
	    public void an_error_message_should_be_returned() {
	        assertTrue(
	            "Expected response body for validation error",
	            response.getBody() != null && response.getBody().asString().length() > 0
	        );
	    }
   
	    @Given("a valid booking payload without deposit")
	    public void a_valid_booking_payload_without_deposit() {

	        String check_in = java.time.LocalDate.now().plusDays(20).toString();
	        String check_out = java.time.LocalDate.now().plusDays(23).toString();

	        int roomId = new java.util.Random().nextInt(100) + 1;

	        booking_Payload = BookingPayloadUtil.createBookingPayload(
	                false,
	                "12345678901"
	        );
	    }

	    
	}
	
	


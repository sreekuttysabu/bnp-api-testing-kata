package com.booking.stepdefinitions;



	import io.cucumber.java.en.*;
	import io.restassured.response.Response;

	import static io.restassured.RestAssured.*;
	import static org.junit.Assert.*;

	public class CreateBookingSteps {

	    private Response response;
	    private String booking_Payload;

	    @Given("a complete and valid set of booking details")
	    public void a_complete_and_valid_set_of_booking_details() {
	    	String check_in = java.time.LocalDate.now().plusDays(10).toString();
	        String check_out = java.time.LocalDate.now().plusDays(13).toString();

	       
	        int roomId = (int) (System.currentTimeMillis() % 5) + 1; // room ids 1–5

	        booking_Payload = """
	            {
	              "roomid": %d,
	              "firstname": "Hazel",
	              "lastname": "Sreekutty",
	              "depositpaid": true,
	              "bookingdates": {
	                "checkin": "%s",
	                "checkout": "%s"
	              },
	              "email": "hazel.sreekutty@example.com",
	              "phone": "12345678901"
	            }
	            """.formatted(roomId, check_in, check_out);
	    }

	    @When("I submit the request to create a new booking")
	    public void i_submit_the_request_to_create_a_new_booking() {
	    	response = given()
	                .header("Content-Type", "application/json")
	                .accept("application/json")
	                .body(booking_Payload)
	                .when()
	                .post("https://automationintesting.online/api/booking");
	    	response.then().log().all();
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
	}
	
	


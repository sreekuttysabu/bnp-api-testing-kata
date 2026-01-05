package com.booking.utils;

import java.time.LocalDate;
import java.util.Random;

public class BookingPayloadUtil {

    private static final Random RANDOM = new Random();

    public static String createBookingPayload(
            boolean depositPaid,
            String phone
    ) {
        String checkIn = LocalDate.now().plusDays(10).toString();
        String checkOut = LocalDate.now().plusDays(12).toString();
        int roomId = RANDOM.nextInt(100) + 1;

        return """
            {
              "roomid": %d,
              "firstname": "Hazel",
              "lastname": "Sreekutty",
              "depositpaid": %s,
              "bookingdates": {
                "checkin": "%s",
                "checkout": "%s"
              },
              "email": "hazel.sreekutty@example.com",
              "phone": "%s"
            }
            """.formatted(roomId, depositPaid, checkIn, checkOut, phone);
    }
}

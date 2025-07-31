
package controllers;

import services.BookingService;

import java.util.Date;

public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public boolean bookRoom(String roomId, Date date, int startTime, int endTime, int participants) {
        return bookingService.bookMeeting(roomId, date, startTime, endTime, participants);
    }
}

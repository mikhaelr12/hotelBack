package md.project.hotelback.service;

import md.project.hotelback.dto.BookingDTO;
import md.project.hotelback.entity.HotelBooking;

import java.util.List;

public interface BookingService {

    HotelBooking book(BookingDTO bookingDTO, String jwt);

    List<BookingDTO> getBookingsForUser(String jwt);

    void createBookingVariant(BookingDTO bookingDTO, Long bookingId, String token);

    void cancelBooking(String jwt, Long bookingId);
}

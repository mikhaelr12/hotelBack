package md.project.hotelback.service;

import md.project.hotelback.dto.BookingDTO;
import md.project.hotelback.entity.HotelBooking;

public interface BookingService {

    HotelBooking book(BookingDTO bookingDTO, String jwt);
}

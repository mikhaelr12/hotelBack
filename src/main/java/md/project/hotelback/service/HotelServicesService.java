package md.project.hotelback.service;

import md.project.hotelback.dto.BookingDTO;
import md.project.hotelback.entity.HotelBooking;

public interface HotelServicesService {

        void bookServices(String jwt, HotelBooking hotelBooking);
}

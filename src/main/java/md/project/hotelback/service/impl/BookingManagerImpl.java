package md.project.hotelback.service.impl;

import lombok.AllArgsConstructor;
import md.project.hotelback.entity.BookingStatus;
import md.project.hotelback.entity.HotelBooking;
import md.project.hotelback.exception.StatusException;
import md.project.hotelback.repository.HotelBookingRepository;
import md.project.hotelback.repository.StatusRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@AllArgsConstructor
public class BookingManagerImpl {

    private final StatusRepository statusRepository;
    private final HotelBookingRepository hotelBookingRepository;

    public void completeBookings(){
        BookingStatus status = statusRepository.findById(4L)
                .orElseThrow(() -> new StatusException("Booking status not found"));

        List<HotelBooking> bookings = hotelBookingRepository.findAll();
        for (HotelBooking booking : bookings) {
            if(LocalDate.now().isAfter(booking.getCheckOut())){
                booking.setBookingStatus(status);
            }
        }
    }

    public void cancelUnpaidExpiredBookings() {
        List<HotelBooking> bookings = hotelBookingRepository.findAll();
        for (HotelBooking booking : bookings) {
            if(LocalDate.now().isAfter(booking.getCheckIn())
                    && booking.getBookingStatus().getId().equals(statusRepository.findById(1L).get().getId()))
                booking.setBookingStatus(statusRepository.findById(3L)
                        .orElseThrow(() -> new StatusException("Booking status not found")));

        }
        hotelBookingRepository.saveAll(bookings);
    }
}

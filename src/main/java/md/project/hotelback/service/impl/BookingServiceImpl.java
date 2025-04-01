package md.project.hotelback.service.impl;

import lombok.AllArgsConstructor;
import md.project.hotelback.dto.BookingDTO;
import md.project.hotelback.entity.HotelBooking;
import md.project.hotelback.entity.Room;
import md.project.hotelback.entity.User;
import md.project.hotelback.exception.UserException;
import md.project.hotelback.repository.HotelBookingRepository;
import md.project.hotelback.repository.RoomRepository;
import md.project.hotelback.service.BookingService;
import md.project.hotelback.util.RoomPriceCalculator;
import md.project.hotelback.util.UserExtractServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final HotelBookingRepository hotelBookingRepository;
    private final RoomRepository roomRepository;
    private final UserExtractServiceImpl userExtractService;


    @Override
    public HotelBooking book(BookingDTO bookingDTO, String jwt) {
        User user = userExtractService.getUser(jwt);
        if(user == null) {
            throw new UserException("No user found");
        }
        List<HotelBooking> bookings = hotelBookingRepository.findAllByRoomId(bookingDTO.getRoomId());
        for (HotelBooking existingBooking : bookings) {
            if (bookingDTO.getCheckIn().isBefore(existingBooking.getCheckOut()) &&
                    bookingDTO.getCheckOut().isAfter(existingBooking.getCheckIn())) {
                throw new UserException("The selected dates overlap with an existing booking.");
            }
        }
        Room bookingRoom = roomRepository.findById(bookingDTO.getRoomId()).orElse(null);
        assert bookingRoom != null;
        Double price = new RoomPriceCalculator(roomRepository).calculatePrice(bookingDTO);
        return hotelBookingRepository.save(HotelBooking.builder()
                .checkIn(bookingDTO.getCheckIn())
                .checkOut(bookingDTO.getCheckOut())
                .finalPrice(price)
                .user(user)
                .room(bookingRoom)
                .location(bookingRoom.getLocation())
                .bookingStatus(1L)
                .build());
    }
}

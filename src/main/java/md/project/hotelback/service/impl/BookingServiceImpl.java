package md.project.hotelback.service.impl;

import lombok.AllArgsConstructor;
import md.project.hotelback.dto.BookingDTO;
import md.project.hotelback.entity.*;
import md.project.hotelback.exception.BookingException;
import md.project.hotelback.exception.StatusException;
import md.project.hotelback.exception.UserException;
import md.project.hotelback.repository.HotelBookingRepository;
import md.project.hotelback.repository.RoomRepository;
import md.project.hotelback.repository.StatusRepository;
import md.project.hotelback.service.BookingService;
import md.project.hotelback.util.RoomPriceCalculator;
import md.project.hotelback.util.UserExtractServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final HotelBookingRepository hotelBookingRepository;
    private final RoomRepository roomRepository;
    private final UserExtractServiceImpl userExtractService;
    private final StatusRepository statusRepository;

    @Override
    public HotelBooking book(BookingDTO bookingDTO, String jwt) {
        User user = userExtractService.getUser(jwt);
        if (user == null) {
            throw new UserException("No user found");
        }

        List<HotelBooking> bookings = hotelBookingRepository.findAllByRoomId(bookingDTO.getRoomId());
        for (HotelBooking existingBooking : bookings) {
            if (bookingDTO.getCheckIn().isBefore(existingBooking.getCheckOut()) &&
                    bookingDTO.getCheckOut().isAfter(existingBooking.getCheckIn())) {
                throw new UserException("The selected dates overlap with an existing booking.");
            }
        }

        Room bookingRoom = roomRepository.findById(bookingDTO.getRoomId())
                .orElseThrow(() -> new UserException("Room not found"));

        if (bookingRoom.getHotel() == null) {
            throw new UserException("The selected room is not associated with any hotel.");
        }

        bookingDTO.setRoom(bookingRoom);

        Double price = new RoomPriceCalculator(roomRepository).calculatePrice(bookingDTO);
        BookingStatus status = statusRepository.findById(1L)
                .orElseThrow(() -> new UserException("Booking status not found"));

        return hotelBookingRepository.save(HotelBooking.builder()
                .checkIn(bookingDTO.getCheckIn())
                .checkOut(bookingDTO.getCheckOut())
                .finalPrice(price)
                .user(user)
                .room(bookingRoom)
                .hotel(bookingRoom.getHotel())
                .bookingStatus(status)
                .build());
    }

    @Override
    public List<BookingDTO> getBookingsForUser(String jwt) {
        User user = userExtractService.getUser(jwt);
        if (user == null){
            throw new UserException("No user found");
        }
        List<HotelBooking> bookings = hotelBookingRepository.findAllByUserId(user.getId());
        return bookings.stream().map(b -> new BookingDTO.Builder()
                .bookingId(b.getId())
                .price(b.getFinalPrice())
                .status(b.getBookingStatus())
                .room(b.getRoom())
                .roomId(b.getRoom().getId())
                .checkOut(b.getCheckOut())
                .checkIn(b.getCheckIn())
                .hotel(b.getHotel())
                .hotelId(b.getHotel().getId())
                .build()).toList();
    }

    @Override
    public void createBookingVariant(BookingDTO bookingDTO, Long bookingId, String token) {
        User user = userExtractService.getUser(token);
        if (user == null) {
            throw new UserException("No user found");
        }

        HotelBooking original = hotelBookingRepository.findById(bookingId)
                .orElseThrow(() -> new UserException("Original booking not found"));

        if (!bookingDTO.getCheckIn().isBefore(bookingDTO.getCheckOut())) {
            throw new UserException("Check‑in must be before check‑out");
        }

        long days = ChronoUnit.DAYS.between(
                bookingDTO.getCheckIn(),
                bookingDTO.getCheckOut()
        );

        HotelBooking variant = (HotelBooking) original.clone();
        variant.setCheckIn(bookingDTO.getCheckIn());
        variant.setCheckOut(bookingDTO.getCheckOut());
        variant.setFinalPrice( variant.getRoom().getPrice() * days );
        variant.setBookingStatus(statusRepository.findById(1L).get());

        hotelBookingRepository.save(variant);
    }


    @Override
    public void cancelBooking(String jwt, Long bookingId) {
        User user = userExtractService.getUser(jwt);
        if (user == null)
            throw new UserException("No user found");

        HotelBooking booking = hotelBookingRepository.findById(bookingId).orElse(null);
        BookingStatus status = statusRepository.findById(3L)
                .orElseThrow(() -> new StatusException("Booking status not found"));

        if (booking == null)
            throw new BookingException("Booking not found");

        if (booking.getUser().getId() != user.getId())
            throw new BookingException("Booking doesnt belong to this user");

        booking.setBookingStatus(status);
        hotelBookingRepository.save(booking);
    }


}

package md.project.hotelback.proxy;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import md.project.hotelback.dto.BookingDTO;
import md.project.hotelback.entity.HotelBooking;
import md.project.hotelback.entity.User;
import md.project.hotelback.exception.UserException;
import md.project.hotelback.service.BookingService;
import md.project.hotelback.util.UserExtractServiceImpl;

import java.util.List;

@AllArgsConstructor
@Slf4j
public class BookingServiceProxy implements BookingService {

    private final BookingService delegate;
    private final UserExtractServiceImpl userExtractService;

    @Override
    public HotelBooking book(BookingDTO bookingDTO, String jwt) {
        User user = userExtractService.getUser(jwt);
        if (user == null) {
            throw new UserException("User must be logged in to make a booking.");
        }
        log.info("User {} is authenticated. Proceeding with booking.", user.getUsername());
        return delegate.book(bookingDTO, jwt);
    }

    @Override
    public List<BookingDTO> getBookingsForUser(String jwt) {
        return delegate.getBookingsForUser(jwt);
    }

    @Override
    public void createBookingVariant(BookingDTO bookingDTO, Long bookingId, String token) {
         delegate.createBookingVariant(bookingDTO, bookingId, token);
    }

    @Override
    public void cancelBooking(String jwt, Long bookingId) {
        delegate.cancelBooking(jwt, bookingId);
    }
}

package md.project.hotelback.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import md.project.hotelback.service.BookingService;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component("cancel")
public class CancelBookingCommand implements Command {

    private final BookingService bookingService;

    @Override
    public void execute(String jwt, Long bookingId) {
        bookingService.cancelBooking(jwt, bookingId);
    }
}

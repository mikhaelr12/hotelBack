package md.project.hotelback.controller;

import lombok.AllArgsConstructor;
import md.project.hotelback.command.BookingCommandInvoker;
import md.project.hotelback.dto.BookingDTO;
import md.project.hotelback.dto.response.BookingResponse;
import md.project.hotelback.service.BookingService;
import md.project.hotelback.util.TokenExtractServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@AllArgsConstructor
public class BookingController {

    private final BookingFacade bookingFacade;
    private final BookingService bookingService;
    private final BookingCommandInvoker bookingCommandInvoker;

    @PostMapping()
    public ResponseEntity<BookingResponse> book(@RequestBody BookingDTO bookingDTO,
                                                @RequestHeader("Authorization") String token) {
        BookingResponse hotelBooking = bookingFacade.book(bookingDTO, token);
        return ResponseEntity.ok(hotelBooking);
    }

    @GetMapping()
    public ResponseEntity<List<BookingDTO>> getBookings(@RequestHeader("Authorization") String token) {
        TokenExtractServiceImpl tokenExtractService = TokenExtractServiceImpl.getInstance();
        String jwt = tokenExtractService.getToken(token);
        return ResponseEntity.ok(bookingService.getBookingsForUser(jwt));
    }

    @PostMapping("/variant/{bookingId}")
    public ResponseEntity<?> createVariantBooking(@RequestHeader("Authorization") String token,
                                                  @RequestBody BookingDTO bookingDTO,
                                                  @PathVariable("bookingId") Long bookingId) {
        TokenExtractServiceImpl tokenExtractService = TokenExtractServiceImpl.getInstance();
        String jwt = tokenExtractService.getToken(token);
        bookingService.createBookingVariant(bookingDTO, bookingId, jwt);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/cancel/{bookingId}")
    public ResponseEntity<?> cancelBooking(@RequestHeader("Authorization") String token,
                                           @PathVariable("bookingId") Long bookingId) {
        TokenExtractServiceImpl tokenExtractService = TokenExtractServiceImpl.getInstance();
        String jwt = tokenExtractService.getToken(token);
        bookingCommandInvoker.executeCommand("cancel", jwt, bookingId);
        return ResponseEntity.ok().build();
    }
}

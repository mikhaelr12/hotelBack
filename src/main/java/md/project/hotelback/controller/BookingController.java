package md.project.hotelback.controller;

import lombok.AllArgsConstructor;
import md.project.hotelback.dto.BookingDTO;
import md.project.hotelback.dto.response.BookingResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
@AllArgsConstructor
public class BookingController {

    private final BookingFacade bookingFacade;

    @PostMapping()
    public ResponseEntity<BookingResponse> book(@RequestBody BookingDTO bookingDTO,
                                                @RequestHeader("Authorization") String token) {
        BookingResponse hotelBooking = bookingFacade.book(bookingDTO, token);
        return ResponseEntity.ok(hotelBooking);
    }
}

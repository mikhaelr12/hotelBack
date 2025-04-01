package md.project.hotelback.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import md.project.hotelback.entity.HotelBooking;

@Data
@AllArgsConstructor
public class BookingResponse {
    private Long bookingId;
    private HotelBooking hotelBooking;
}

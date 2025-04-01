package md.project.hotelback.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingDTO {
    private LocalDate checkIn;
    private LocalDate checkOut;
    private Long roomId;
    private String notificationType;
}

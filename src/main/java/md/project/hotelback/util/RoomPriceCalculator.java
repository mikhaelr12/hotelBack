package md.project.hotelback.util;

import lombok.AllArgsConstructor;
import md.project.hotelback.dto.BookingDTO;
import md.project.hotelback.entity.Room;
import md.project.hotelback.repository.RoomRepository;
import org.springframework.stereotype.Component;

import java.time.temporal.ChronoUnit;

@Component
@AllArgsConstructor
public class RoomPriceCalculator {

    private final RoomRepository roomRepository;

    public Double calculatePrice(BookingDTO bookingDTO){
        Room room = roomRepository.findById(bookingDTO.getRoomId()).get();
        long days = ChronoUnit.DAYS.between(bookingDTO.getCheckIn(), bookingDTO.getCheckOut());
        return days * room.getPrice();
    }
}

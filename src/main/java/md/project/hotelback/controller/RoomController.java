package md.project.hotelback.controller;

import lombok.AllArgsConstructor;
import md.project.hotelback.dto.BookingDTO;
import md.project.hotelback.dto.RoomDTO;
import md.project.hotelback.entity.Room;
import md.project.hotelback.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@AllArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping("/{hotelId}")
    public ResponseEntity<List<RoomDTO>> getRoomByHotelId(@PathVariable Long hotelId) {
        return ResponseEntity.ok(roomService.getRoomByHotelId(hotelId));
    }

    @GetMapping("/bookings/{roomId}")
    public ResponseEntity<List<BookingDTO>> getRoomBookings(@PathVariable Long roomId) {
        return ResponseEntity.ok(roomService.getRoomBookings(roomId));
    }

}

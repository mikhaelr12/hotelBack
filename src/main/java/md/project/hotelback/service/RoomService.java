package md.project.hotelback.service;

import md.project.hotelback.dto.BookingDTO;
import md.project.hotelback.dto.RoomDTO;

import java.util.List;

public interface RoomService {
    List<RoomDTO> getRoomByHotelId(Long hotelId);

    List<BookingDTO> getRoomBookings(Long roomId);
}

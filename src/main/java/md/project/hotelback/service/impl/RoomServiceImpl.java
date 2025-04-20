package md.project.hotelback.service.impl;

import lombok.AllArgsConstructor;
import md.project.hotelback.dto.BookingDTO;
import md.project.hotelback.dto.RoomDTO;
import md.project.hotelback.entity.HotelBooking;
import md.project.hotelback.entity.Room;
import md.project.hotelback.repository.HotelBookingRepository;
import md.project.hotelback.repository.RoomRepository;
import md.project.hotelback.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final HotelBookingRepository hotelBookingRepository;

    @Override
    public List<RoomDTO> getRoomByHotelId(Long hotelId) {
        List<Room> rooms = roomRepository.findAllByHotelId(hotelId);
        return rooms.stream().map(r -> RoomDTO.builder()
                .id(r.getId())
                .hotel(r.getHotel())
                .roomType(r.getRoomType())
                .price(r.getPrice())
                .image("/images" + r.getImage())
                .description(r.getDescription())
                .noPeople(r.getNoPeople())
                .build()).toList();
    }

    @Override
    public List<BookingDTO> getRoomBookings(Long roomId) {
        List<HotelBooking> bookings = hotelBookingRepository.findAllByRoomId(roomId);
        List<HotelBooking> filtered = bookings.stream()
                .filter(h -> "Confirmed".equals(h.getBookingStatus().getStatusName())
                        || "Pending".equals(h.getBookingStatus().getStatusName()))
                .toList();
        return filtered.stream().map(b-> new BookingDTO.Builder()
                .checkIn(b.getCheckIn())
                .checkOut(b.getCheckOut())
                .build()).toList();
    }
}

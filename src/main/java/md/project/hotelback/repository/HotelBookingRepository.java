package md.project.hotelback.repository;

import md.project.hotelback.entity.HotelBooking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelBookingRepository extends JpaRepository<HotelBooking, Long> {
    List<HotelBooking> findAllByRoomId(Long roomId);
}

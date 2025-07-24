package md.project.hotelback.repository;

import md.project.hotelback.entity.HotelBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelBookingRepository extends JpaRepository<HotelBooking, Long> {
    List<HotelBooking> findAllByRoomId(Long roomId);

    List<HotelBooking> findAllByUserId(Long id);
}

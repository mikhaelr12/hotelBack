package md.project.hotelback.repository;

import md.project.hotelback.entity.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<BookingStatus, Long> {
}

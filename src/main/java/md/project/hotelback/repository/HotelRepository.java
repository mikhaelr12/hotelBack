package md.project.hotelback.repository;

import md.project.hotelback.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findByCountryId(Long countryId);

    Hotel findFirstByCountryId(long l);
}

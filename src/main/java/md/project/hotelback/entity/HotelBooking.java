package md.project.hotelback.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "hotel_bookings")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HotelBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotel_booking_id_seq")
    @SequenceGenerator(name = "hotel_booking_id_seq", allocationSize = 1, sequenceName = "hotel_booking_id_seq")
    private Long id;

    @Column(name = "check_in", nullable = false)
    private LocalDate checkIn;

    @Column(name = "check_out", nullable = false)
    private LocalDate checkOut;

    @Column(name = "final_price", nullable = false)
    private Double finalPrice;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_USER_BOOKING"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "location_id", foreignKey = @ForeignKey(name = "FK_LOCATION_BOOKING"))
    private Location location;

    @ManyToOne
    @JoinColumn(name = "room_id", foreignKey = @ForeignKey(name = "FK_ROOM_BOOKING"))
    private Room room;

    @Column(name = "status_id")
    private Long bookingStatus;
}

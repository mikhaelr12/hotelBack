package md.project.hotelback.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "hotel_bookings")
@Data
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

    @ManyToOne
    @JoinColumn(name = "status_id", foreignKey = @ForeignKey(name = "FK_STATUS_BOOKING"))
    private BookingStatus bookingStatus;
}

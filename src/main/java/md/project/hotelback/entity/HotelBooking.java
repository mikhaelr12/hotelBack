package md.project.hotelback.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import md.project.hotelback.prototype.BookingPrototype;

import java.time.LocalDate;

@Entity
@Table(name = "hotel_bookings")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HotelBooking implements BookingPrototype {

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
    @JoinColumn(name = "hotel_id", foreignKey = @ForeignKey(name = "FK_HOTEL_BOOKING"))
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "room_id", foreignKey = @ForeignKey(name = "FK_ROOM_BOOKING"))
    private Room room;

    @ManyToOne
    @JoinColumn(name = "status_id", foreignKey = @ForeignKey(name ="FK_STATUS_BOOKING"))
    private BookingStatus bookingStatus;

    @Override
    public BookingPrototype clone() {
        try {
            HotelBooking clone = (HotelBooking) super.clone();
            clone.setId(null);
            return clone;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

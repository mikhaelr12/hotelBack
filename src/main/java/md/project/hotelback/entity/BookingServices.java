package md.project.hotelback.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "booking_services")
public class BookingServices {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_services_id_seq")
    @SequenceGenerator(name = "booking_services_id_seq", allocationSize = 1, sequenceName = "booking_services_id_seq")
    private Long id;

    @OneToOne
    @JoinColumn(name = "booking_id", foreignKey = @ForeignKey(name = "FK_BOOKING_SERVICES"))
    private HotelBooking hotelBooking;

    @ManyToMany
    @JoinTable(
            name = "booking_services_services",
            joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private Set<HotelServices> hotelServices = new HashSet<>();
}

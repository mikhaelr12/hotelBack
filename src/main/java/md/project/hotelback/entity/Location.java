package md.project.hotelback.entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "locations")
@Entity
@Data
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "location_id_seq")
    @SequenceGenerator(name = "location_id_seq", allocationSize = 1, sequenceName = "location_id_seq")
    private Long id;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel_id", foreignKey = @ForeignKey(name = "FK_HOTEL_LOCATION"))
    private Hotel hotel;
}

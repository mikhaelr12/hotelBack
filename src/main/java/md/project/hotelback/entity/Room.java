package md.project.hotelback.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "rooms")
@Data
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "room_id_seq")
    @SequenceGenerator(name = "room_id_seq", allocationSize = 1, sequenceName = "room_id_seq")
    private Long id;

    @Column(name = "no_people", nullable = false)
    private Integer noPeople;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "type_id", foreignKey = @ForeignKey(name = "FK_TYPE_ROOM"))
    private RoomType roomType;

    @ManyToOne
    @JoinColumn(name = "location_id", foreignKey = @ForeignKey(name = "FK_LOCATION_ROOM"))
    private Location location;
}

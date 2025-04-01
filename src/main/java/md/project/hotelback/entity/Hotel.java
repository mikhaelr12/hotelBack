package md.project.hotelback.entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "hotels")
@Entity
@Data
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotel_id_seq")
    @SequenceGenerator(sequenceName = "hotel_id_seq", allocationSize = 1, name = "hotel_id_seq")
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "country_id", foreignKey = @ForeignKey(name = "FK_COUNTRY_HOTEL"))
    private Country country;
}

package md.project.hotelback.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "countries")
@Data
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "country_id_seq")
    @SequenceGenerator(name = "country_id_seq", allocationSize = 1, sequenceName = "country_id_seq")
    private Long id;

    @Column(name = "country_name", nullable = false)
    private String countryName;

    @Column(name = "city_name", nullable = false)
    private String cityName;
}

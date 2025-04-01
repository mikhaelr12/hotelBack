package md.project.hotelback.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "hotel_services")
@Data
public class HotelServices {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "services_id_seq")
    @SequenceGenerator(name = "services_id_seq", allocationSize = 1, sequenceName = "services_id_seq")
    private Long id;

    @Column(name = "service_name", nullable = false)
    private String serviceName;

}

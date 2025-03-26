package md.project.hotelback.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "booking_statuses")
@Data
public class BookingStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "status_id_seq")
    @SequenceGenerator(name = "status_id_seq", allocationSize = 1, sequenceName = "status_id_seq")
    private Long id;

    @Column(name = "status_name", nullable = false)
    private String statusName;
}

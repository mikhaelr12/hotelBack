package md.project.hotelback.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "room_types")
@Data
public class RoomType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "types_id_seq")
    @SequenceGenerator(name = "types_id_seq", allocationSize = 1, sequenceName = "types_id_seq")
    private Long id;

    @Column(name = "type_name", nullable = false)
    private String typeName;
}

package md.project.hotelback.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user_roles")
@Data
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_role_id_seq")
    @SequenceGenerator(name = "user_role_id_seq", allocationSize = 1, sequenceName = "user_role_id_seq")
    private Long id;

    @Column(name = "role_name", unique = true, nullable = false)
    private String roleName;
}

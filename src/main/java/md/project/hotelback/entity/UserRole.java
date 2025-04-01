package md.project.hotelback.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_roles")
@Data
@NoArgsConstructor
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_role_id_seq")
    @SequenceGenerator(name = "user_role_id_seq", allocationSize = 1, sequenceName = "user_role_id_seq")
    private Long id;

    @Column(name = "role_name", unique = true, nullable = false)
    private String roleName;

    public UserRole(Builder builder) {
        this.id = builder.id;
        this.roleName = builder.roleName;
    }

    public static class Builder{
        private Long id;
        private String roleName;

        public Builder id(Long id){
            this.id = id;
            return this;
        }
        public Builder roleName(String roleName){
            this.roleName = roleName;
            return this;
        }

        public UserRole build(){
            return new UserRole(this);
        }
    }
}

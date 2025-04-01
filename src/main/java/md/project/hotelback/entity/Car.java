package md.project.hotelback.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import md.project.hotelback.prototype.CarPrototype;
import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name = "cars")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Car implements CarPrototype {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_id_seq")
    @SequenceGenerator(name = "car_id_seq", allocationSize = 1, sequenceName = "car_id_seq")
    private Long id;

    @Column(name = "make", nullable = false)
    private String make;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "year", nullable = false)
    private Integer year;

    @ManyToOne
    @JoinColumn(name = "location_id", foreignKey = @ForeignKey(name = "FK_LOCATION_CAR"))
    private Location location;

    @Override
    public CarPrototype clone() {
        try{
            Car car = (Car) super.clone();
            car.setId(null);
            return car;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

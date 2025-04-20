package md.project.hotelback.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import md.project.hotelback.entity.Hotel;
import md.project.hotelback.entity.RoomType;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {
    private Long id;
    private Integer noPeople;
    private Double price;
    private String image;
    private String description;
    private RoomType roomType;
    private Hotel hotel;
}

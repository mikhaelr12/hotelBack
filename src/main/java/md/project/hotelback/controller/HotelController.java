package md.project.hotelback.controller;

import lombok.AllArgsConstructor;
import md.project.hotelback.dto.HotelDTO;
import md.project.hotelback.service.HotelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
@AllArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    @GetMapping
    public ResponseEntity<List<HotelDTO>> getAllHotels() {
        return ResponseEntity.ok(hotelService.getAllHotels());
    }

    @GetMapping("/country/{countryId}")
    public ResponseEntity<List<HotelDTO>> getHotelsByCountryId(@PathVariable Long countryId) {
        return ResponseEntity.ok(hotelService.getAllHotelsByCountryId(countryId));
    }

    @GetMapping("/main-page")
    public ResponseEntity<List<HotelDTO>> getMainPageHotels(){
        return ResponseEntity.ok(hotelService.getMainPageHotels());
    }
}

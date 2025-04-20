package md.project.hotelback.service.impl;

import lombok.AllArgsConstructor;
import md.project.hotelback.dto.HotelDTO;
import md.project.hotelback.entity.Hotel;
import md.project.hotelback.repository.HotelRepository;
import md.project.hotelback.service.HotelService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    @Override
    public List<HotelDTO> getAllHotels() {
        List<Hotel> hotels = hotelRepository.findAll();
        return hotels.stream().map(h -> HotelDTO.builder()
                .name(h.getName())
                .description(h.getDescription())
                .country(h.getCountry())
                .id(h.getId())
                .image("/images" + h.getImage())
                .build()).toList();
    }

    @Override
    public List<HotelDTO> getAllHotelsByCountryId(Long countryId) {
        List<Hotel> hotels = hotelRepository.findByCountryId(countryId);
        return hotels.stream().map(h -> HotelDTO.builder()
                .id(h.getId())
                .name(h.getName())
                .description(h.getDescription())
                .country(h.getCountry())
                .image("/images" + h.getImage())
                .build()).toList();
    }

    @Override
    public List<HotelDTO> getMainPageHotels() {
        Hotel hotel1 = hotelRepository.findFirstByCountryId(1L);
        Hotel hotel2 = hotelRepository.findFirstByCountryId(2L);
        Hotel hotel3 = hotelRepository.findFirstByCountryId(5L);
        Hotel hotel4 = hotelRepository.findFirstByCountryId(6L);
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(hotel1);
        hotels.add(hotel2);
        hotels.add(hotel3);
        hotels.add(hotel4);
        return hotels.stream().map(h -> HotelDTO.builder()
                .id(h.getId())
                .name(h.getName())
                .description(h.getDescription())
                .country(h.getCountry())
                .image("/images" + h.getImage())
                .build()).toList();
    }
}

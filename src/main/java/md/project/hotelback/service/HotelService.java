package md.project.hotelback.service;

import md.project.hotelback.dto.HotelDTO;
import md.project.hotelback.entity.Hotel;

import java.util.List;

public interface HotelService {
    List<HotelDTO> getAllHotels();

    List<HotelDTO> getAllHotelsByCountryId(Long countryId);

    List<HotelDTO> getMainPageHotels();

}

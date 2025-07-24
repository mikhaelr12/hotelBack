package md.project.hotelback.service.impl;

import md.project.hotelback.dto.CountryDTO;
import md.project.hotelback.entity.Country;
import md.project.hotelback.repository.CountryRepository;
import md.project.hotelback.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private CountryRepository countryRepository;

    @Override
    public List<CountryDTO> getAllCountries() {
        List<Country> countries = countryRepository.findAll();
        return countries.stream().map(c -> CountryDTO.builder()
                .id(c.getId())
                .countryName(c.getCountryName())
                .cityName(c.getCityName())
                .build()).toList();
    }
}

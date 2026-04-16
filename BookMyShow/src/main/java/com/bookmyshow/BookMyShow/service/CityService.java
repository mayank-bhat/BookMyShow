package com.bookmyshow.BookMyShow.service;

import com.bookmyshow.BookMyShow.dto.CityRequest;
import com.bookmyshow.BookMyShow.entity.City;
import com.bookmyshow.BookMyShow.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CityService {
    private final CityRepository cityRepository;

    public City addCity(City city){
        return cityRepository.save(city);
    }

    public City addCity(CityRequest cityRequest)
    {
        City city = City.builder()
                .name(cityRequest.getName())
                .pinCode(cityRequest.getPinCode())
                .state(cityRequest.getState())
                .build();
        return cityRepository.save(city);
    }

    public List<City> getAllCities(){
        return cityRepository.findAll();
    }

    public City getCityById(Long id){
        return cityRepository.findById(id)
                .orElseThrow(()->new RuntimeException("City Not Found having id : "+String.valueOf(id)));
    }

    public List<City> getCitiesByState(String stateName){
        return cityRepository.findByStateContainingIgnoreCase(stateName);
    }

    public List<City> searchCityByName(String name){
        return cityRepository.findByNameContainingIgnoreCase(name);
    }
}

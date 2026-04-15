package com.bookmyshow.BookMyShow.service;

import com.bookmyshow.BookMyShow.dto.TheaterRequest;
import com.bookmyshow.BookMyShow.entity.City;
import com.bookmyshow.BookMyShow.entity.Theater;
import com.bookmyshow.BookMyShow.repository.CityRepository;
import com.bookmyshow.BookMyShow.repository.TheaterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TheaterService {
    private final TheaterRepository theaterRepository;
    private final CityService cityService;

    public Theater addTheater(TheaterRequest theaterRequest){
        City city = cityService.getCityById(theaterRequest.getCityId());
        Theater theater = Theater.builder()
                .name(theaterRequest.getName())
                .address(theaterRequest.getAddress())
                .city(city)
                .build();
        return theaterRepository.save(theater);
    }

    public List<Theater> getAllTheater(){
        return theaterRepository.findAll();
    }

    public Theater getTheaterById(Long id){
        System.out.println("TheaterService....................");
        return theaterRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Theater Not Found having ID : "+String.valueOf(id)));
    }

    public List<Theater> getTheaterByCity(Long id){
        return theaterRepository.findByCityId(id);
    }
}

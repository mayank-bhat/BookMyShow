package com.bookmyshow.BookMyShow.controller;


import com.bookmyshow.BookMyShow.dto.CityRequest;
import com.bookmyshow.BookMyShow.dto.MovieRequest;
import com.bookmyshow.BookMyShow.entity.City;
import com.bookmyshow.BookMyShow.entity.Movie;
import com.bookmyshow.BookMyShow.service.CityService;
import com.bookmyshow.BookMyShow.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;

    @PostMapping("/add-city")
    private ResponseEntity<City> addCity(@RequestBody CityRequest cityRequest){
        return ResponseEntity.ok(cityService.addCity(cityRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCityById(@PathVariable Long id){
        return ResponseEntity.ok(cityService.getCityById(id));
    }

    @GetMapping("/state/{stateName}")
    public ResponseEntity<List<City>> getCitiesByStateName(@PathVariable String stateName){
        return ResponseEntity.ok(cityService.getCitiesByStateName(stateName));
    }

    @GetMapping
    public ResponseEntity<List<City>> getAllCities(){
        return ResponseEntity.ok(cityService.getAllCities());
    }

}

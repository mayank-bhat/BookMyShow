package com.bookmyshow.BookMyShow.controller;

import com.bookmyshow.BookMyShow.dto.TheaterRequest;
import com.bookmyshow.BookMyShow.entity.Theater;
import com.bookmyshow.BookMyShow.service.TheaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/theaters")
@RequiredArgsConstructor
public class TheaterController {

    private final TheaterService theaterService;

    @PostMapping("/add-theater")
    private ResponseEntity<Theater> addTheater(@RequestBody TheaterRequest theaterRequest){
        return ResponseEntity.ok(theaterService.addTheater(theaterRequest));
    }

    @GetMapping
    public ResponseEntity<List<Theater>> getAllTheater(){
        return ResponseEntity.ok(theaterService.getAllTheater());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Theater> getTheaterById(@PathVariable Long id){
        return ResponseEntity.ok(theaterService.getTheaterById(id));
    }

    @GetMapping("/city/{cityId}")
    public ResponseEntity<List<Theater>> getTheaterByCity(@PathVariable Long cityId){
        return ResponseEntity.ok(theaterService.getTheaterByCity(cityId));
    }
}

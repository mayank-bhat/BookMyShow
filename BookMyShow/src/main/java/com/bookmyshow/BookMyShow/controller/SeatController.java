package com.bookmyshow.BookMyShow.controller;


import com.bookmyshow.BookMyShow.dto.SeatRequest;
import com.bookmyshow.BookMyShow.entity.Seat;
import com.bookmyshow.BookMyShow.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
@RequiredArgsConstructor
public class SeatController {

    private final SeatService seatService;

    @PostMapping("/add-seat")
    public ResponseEntity<Seat> addSeat(@RequestBody SeatRequest seatRequest){
        return ResponseEntity.ok(seatService.addSeat(seatRequest));
    }

    @PostMapping("/add-all-seats")
    public ResponseEntity<List<Seat>> addAllSeats(@RequestBody List<SeatRequest> seatRequestList){
        return ResponseEntity.ok(seatService.addAllSeats(seatRequestList));
    }

    @GetMapping("/screen/{screenId}")
    public ResponseEntity<List<Seat>> getAllSeat(@PathVariable Long screenId){
        return ResponseEntity.ok(seatService.getSeatByScreen(screenId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seat> getSeatById(@PathVariable Long id){
        return ResponseEntity.ok(seatService.getSeatById(id));
    }



}

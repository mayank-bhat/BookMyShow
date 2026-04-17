package com.bookmyshow.BookMyShow.controller;


import com.bookmyshow.BookMyShow.dto.BookingRequest;
import com.bookmyshow.BookMyShow.entity.Booking;
import com.bookmyshow.BookMyShow.entity.Seat;
import com.bookmyshow.BookMyShow.service.BookingServiece;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {
    private final BookingServiece bookingServiece;

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody BookingRequest bookingRequest){
        return ResponseEntity.ok(bookingServiece.createBooking(bookingRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id){
        return ResponseEntity.ok(bookingServiece.getBookingById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Booking>> getBookingByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(bookingServiece.getBookingByUserId(userId));
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<Booking> cancelBookingId(@PathVariable Long id){
        return ResponseEntity.ok(bookingServiece.cancelBooking(id));
    }

    @GetMapping("show/{showId}/available-seats")
    public ResponseEntity<List<Seat>> getAvailableSeats(@PathVariable Long showId){
        return ResponseEntity.ok(bookingServiece.getAvailableSeats(showId));
    }

}

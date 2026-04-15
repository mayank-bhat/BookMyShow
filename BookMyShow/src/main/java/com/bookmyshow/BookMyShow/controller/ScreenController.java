package com.bookmyshow.BookMyShow.controller;


import com.bookmyshow.BookMyShow.dto.ScreenRequest;
import com.bookmyshow.BookMyShow.dto.SeatRequest;
import com.bookmyshow.BookMyShow.entity.Screen;
import com.bookmyshow.BookMyShow.entity.Seat;
import com.bookmyshow.BookMyShow.service.ScreenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/screens")
@RequiredArgsConstructor
public class ScreenController {
    private final ScreenService screenService;

    @PostMapping("/add-screen")
    private ResponseEntity<Screen> addScreen(@RequestBody ScreenRequest screenRequest){
        System.out.println("ScreenController....................");
        return ResponseEntity.ok(screenService.addScreen(screenRequest));
    }

    @GetMapping
    public ResponseEntity<List<Screen>> getAllScreens(){
        return ResponseEntity.ok(screenService.getAllScreens());
    }

    @GetMapping("/theater/{theaterId}")
    public ResponseEntity<List<Screen>> getAllSeat(@PathVariable Long theaterId){
        return ResponseEntity.ok(screenService.getScreenByTheaterId(theaterId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Screen> getscreenById(@PathVariable Long id){
        return ResponseEntity.ok(screenService.getScreenById(id));
    }
}

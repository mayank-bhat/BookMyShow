package com.bookmyshow.BookMyShow.controller;


import com.bookmyshow.BookMyShow.dto.ShowRequest;
import com.bookmyshow.BookMyShow.dto.TheaterRequest;
import com.bookmyshow.BookMyShow.entity.Show;
import com.bookmyshow.BookMyShow.entity.Theater;
import com.bookmyshow.BookMyShow.service.ShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/shows")
@RequiredArgsConstructor
public class ShowController {
    public final ShowService showService;

    @GetMapping
    public ResponseEntity<List<Show>> getAllShows(){
        return ResponseEntity.ok(showService.getAllShows());
    }

    @PostMapping("/add-show")
    private ResponseEntity<Show> addShow(@RequestBody ShowRequest showRequest){
        return ResponseEntity.ok(showService.addShow(showRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Show> getShowById(@PathVariable Long id){
        return ResponseEntity.ok(showService.getShowById(id));
    }

    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<Show>> getShowByMovie(@PathVariable Long movieId){
        return ResponseEntity.ok(showService.getShowByMovieId(movieId));
    }

    @GetMapping("/movie/{movieId}/date")
    public ResponseEntity<List<Show>> getShowByMovieAndDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Long movieId, @RequestParam LocalDate date){
        return ResponseEntity.ok(showService.getShowByMovieAndDate(movieId,date));
    }


}

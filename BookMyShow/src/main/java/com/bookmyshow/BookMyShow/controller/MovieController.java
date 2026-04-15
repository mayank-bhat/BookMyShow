package com.bookmyshow.BookMyShow.controller;


import com.bookmyshow.BookMyShow.dto.MovieRequest;
import com.bookmyshow.BookMyShow.dto.ScreenRequest;
import com.bookmyshow.BookMyShow.entity.Movie;
import com.bookmyshow.BookMyShow.entity.Screen;
import com.bookmyshow.BookMyShow.repository.MovieRepository;
import com.bookmyshow.BookMyShow.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @PostMapping("/add-movie")
    private ResponseEntity<Movie> addMovie(@RequestBody MovieRequest movieRequest){
        return ResponseEntity.ok(movieService.addMovie(movieRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id){
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovie(){
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Movie>> searchMovieByTitle(@RequestParam String title){
        return ResponseEntity.ok(movieService.searchByTitle(title));
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre){
        return ResponseEntity.ok(movieService.searchByGenre(genre));
    }

    @GetMapping("/language/{language}")
    public ResponseEntity<List<Movie>> getMovieByLanguage(@PathVariable String language){
        return ResponseEntity.ok(movieService.searchByLanguage(language));
    }

}

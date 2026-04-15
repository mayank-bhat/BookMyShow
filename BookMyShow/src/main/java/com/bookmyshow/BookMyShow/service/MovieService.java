package com.bookmyshow.BookMyShow.service;

import com.bookmyshow.BookMyShow.dto.MovieRequest;
import com.bookmyshow.BookMyShow.entity.Movie;
import com.bookmyshow.BookMyShow.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    public Movie addMovie(MovieRequest movieRequest){
        Movie movie = Movie.builder()
                .description(movieRequest.getDescription())
                .durationInMinutes(movieRequest.getDurationInMinutes())
                .genre(movieRequest.getGenre())
                .rating(movieRequest.getRating())
                .title(movieRequest.getTitle())
                .language(movieRequest.getLanguage())
                .releasedDate(movieRequest.getReleasedDate())
                .posterUrl(movieRequest.getPosterUrl())
                .build();
        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id){
        return movieRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Movie not Found having ID : "+String.valueOf(id)));
    }

    public List<Movie> searchByTitle(String title){
        return movieRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Movie> searchByGenre(String genre){
        return movieRepository.findByGenre(genre);
    }

    public List<Movie> searchByLanguage(String language){
        return movieRepository.findByLanguage(language);
    }

    public Movie updateMovie(Long movieId, Movie movie){
        Movie availableMovie = movieRepository.findById(movieId)
                .orElseThrow(()->new RuntimeException("Movie not Found having ID : "+String.valueOf(movieId)));

        availableMovie.setTitle(movie.getTitle());
        availableMovie.setDescription(movie.getDescription());
        availableMovie.setGenre(movie.getGenre());
        availableMovie.setLanguage(movie.getLanguage());
        availableMovie.setRating(movie.getRating());
        availableMovie.setPosterUrl(movie.getPosterUrl());
        availableMovie.setReleasedDate(movie.getReleasedDate());
        availableMovie.setDurationInMinutes(movie.getDurationInMinutes());

        return movieRepository.save(availableMovie);
    }

    public void deleteMovie(Movie movie){
        Movie availableMovie = movieRepository.findById(movie.getId())
                .orElseThrow(()->new RuntimeException("Movie not Found having ID : "+String.valueOf(movie.getId())));

        movieRepository.delete(availableMovie);
    }
}

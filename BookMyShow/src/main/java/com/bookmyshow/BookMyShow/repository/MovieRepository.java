package com.bookmyshow.BookMyShow.repository;

import com.bookmyshow.BookMyShow.entity.Movie;
import com.bookmyshow.BookMyShow.entity.Screen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByGenre(String genre);
    List<Movie> findByLanguage(String language);
    List<Movie> findByTitleContainingIgnoreCase(String title);
}

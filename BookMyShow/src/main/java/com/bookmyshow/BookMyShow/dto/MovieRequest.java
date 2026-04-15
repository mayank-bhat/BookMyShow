package com.bookmyshow.BookMyShow.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MovieRequest {
    private String title;
    private String description;
    private String genre;
    private String language;
    private Integer durationInMinutes;
    private Double rating;
    private LocalDate releasedDate;
    private String posterUrl;
}

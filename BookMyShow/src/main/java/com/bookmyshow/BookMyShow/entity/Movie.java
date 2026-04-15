package com.bookmyshow.BookMyShow.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "Movies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String genre;

    private String language;

    @Column(nullable = false)
    private Integer durationInMinutes;

    @Column(nullable = false)
    private Double rating;

    @Column(nullable = false)
    private LocalDate releasedDate;

    private String posterUrl;
}

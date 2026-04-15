package com.bookmyshow.BookMyShow.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Cities")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "pin_code", nullable = false, unique = true)
    private String pinCode;

    private String state;
}

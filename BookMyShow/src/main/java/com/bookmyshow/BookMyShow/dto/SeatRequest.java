package com.bookmyshow.BookMyShow.dto;

import com.bookmyshow.BookMyShow.enums.SeatType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SeatRequest {
    private String seatNo;
    private String row;
    private Integer col;
    private SeatType seatType;
    private Long screenId;
}

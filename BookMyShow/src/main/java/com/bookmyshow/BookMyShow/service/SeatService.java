package com.bookmyshow.BookMyShow.service;

import com.bookmyshow.BookMyShow.dto.SeatRequest;
import com.bookmyshow.BookMyShow.entity.Screen;
import com.bookmyshow.BookMyShow.entity.Seat;
import com.bookmyshow.BookMyShow.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SeatService {
    private final SeatRepository seatRepository;
    private final ScreenService screenService;

    public Seat addSeat(SeatRequest seatRequest){
        Screen screen = screenService.getScreenById(seatRequest.getScreenId());

        Seat seat = Seat.builder()
                .seatNumber(seatRequest.getSeatNo())
                .seatType(seatRequest.getSeatType())
                .screen(screen)
                .row(seatRequest.getRow())
                .col(seatRequest.getCol())
                .build();
        return seatRepository.save(seat);
    }

    public List<Seat> getSeatByScreen(Long screenId){
        return seatRepository.findByScreenId(screenId);
    }

    public Seat getSeatById(Long id){
        return seatRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Seat not found having ID : "+String.valueOf(id)));
    }


    public List<Seat> addAllSeats(List<SeatRequest> seatRequestList){
        List<Seat> seatList = new ArrayList<>();
        for(SeatRequest seatRequest : seatRequestList){
            Screen screen = screenService.getScreenById(seatRequest.getScreenId());
            Seat seat = Seat.builder()
                    .seatNumber(seatRequest.getSeatNo())
                    .seatType(seatRequest.getSeatType())
                    .screen(screen)
                    .row(seatRequest.getRow())
                    .col(seatRequest.getCol())
                    .build();

            seatList.add(seat);
        }
        return seatRepository.saveAll(seatList);
    }


}

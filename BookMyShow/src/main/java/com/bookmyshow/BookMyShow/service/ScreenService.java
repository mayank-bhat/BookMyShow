package com.bookmyshow.BookMyShow.service;

import com.bookmyshow.BookMyShow.dto.ScreenRequest;
import com.bookmyshow.BookMyShow.entity.Screen;
import com.bookmyshow.BookMyShow.entity.Theater;
import com.bookmyshow.BookMyShow.repository.ScreenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScreenService {
    public final ScreenRepository screenRepository;
    public final TheaterService theaterService;

    public Screen addScreen(ScreenRequest screenRequest){
        Theater theater = theaterService.getTheaterById(screenRequest.getTheaterId());
        Screen screen = Screen.builder()
                .name(screenRequest.getName())
                .theater(theater)
                .totalSeats(screenRequest.getTotalSeats())
                .build();
        System.out.println("ScreenService....................");
        return screenRepository.save(screen);
    }

    public List<Screen> getAllScreens(){
        return screenRepository.findAll();
    }

    public Screen getScreenById(Long id){
        return screenRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Screen Not Found having ID : "+String.valueOf(id)));
    }

    public List<Screen> getScreenByTheaterId(Long theaterId){
        return screenRepository.findByTheaterId(theaterId);
    }
}

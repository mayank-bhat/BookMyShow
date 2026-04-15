package com.bookmyshow.BookMyShow.service;

import com.bookmyshow.BookMyShow.dto.ShowRequest;
import com.bookmyshow.BookMyShow.entity.Movie;
import com.bookmyshow.BookMyShow.entity.Screen;
import com.bookmyshow.BookMyShow.entity.Show;
import com.bookmyshow.BookMyShow.repository.ShowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ShowService {
    private final ShowRepository showRepository;
    private final MovieService movieService;
    private final ScreenService screenService;

    public Show addShow(ShowRequest showRequest){
        Movie movie = movieService.getMovieById(showRequest.getMovieId());
        Screen screen = screenService.getScreenById(showRequest.getScreenId());
        Show show = Show.builder()
                .showDate(showRequest.getShowDate())
                .screen(screen)
                .movie(movie)
                .startTime(showRequest.getStartTime())
                .endTime(showRequest.getEndTime())
                .ticketPrice(showRequest.getTicketPrice())
                .build();
        return showRepository.save(show);
    }

    public List<Show> getAllShows(){
        return showRepository.findAll();
    }

    public Show getShowById(Long id){
        return showRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Show not Found having ID : "+String.valueOf(id)));
    }

    public List<Show> getShowByMovieId(Long movieId){
        return showRepository.findByMovieId(movieId);
    }

    public List<Show> getShowByMovieAndDate(Long movieId, LocalDate date){
        return showRepository.findByMovieIdAndShowDate(movieId,date);
    }

    public List<Show> getShowByScreenAndDate(Long screenId, LocalDate date){
        return showRepository.findByScreenIdAndShowDate(screenId, date);
    }

    public List<Show> getShowByScreen(Long screenId){
        return showRepository.findByScreenId(screenId);
    }

}

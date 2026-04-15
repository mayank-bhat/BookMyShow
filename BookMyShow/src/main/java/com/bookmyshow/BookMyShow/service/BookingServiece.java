package com.bookmyshow.BookMyShow.service;

import com.bookmyshow.BookMyShow.dto.BookingRequest;
import com.bookmyshow.BookMyShow.entity.Booking;
import com.bookmyshow.BookMyShow.entity.Seat;
import com.bookmyshow.BookMyShow.entity.Show;
import com.bookmyshow.BookMyShow.entity.User;
import com.bookmyshow.BookMyShow.enums.BookingStatus;
import com.bookmyshow.BookMyShow.repository.BookingRepository;
import com.bookmyshow.BookMyShow.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiece {
    private final BookingRepository bookingRepository;
    private final SeatService seatService;
    private final UserService userService;
    private final ShowService showService;
    private final SeatRepository seatRepository;

    @Transactional
    public Booking createBooking(BookingRequest bookingRequest){
        User user = userService.getUserById(bookingRequest.getUserId());
        Show show = showService.getShowById(bookingRequest.getShowId());

        //check if any of the requested seat are already booked or not
        List<Long> alreadyBookedSeat = bookingRepository.findBookedSeatIdsByShowId(show.getId());

        for(Long seatId : bookingRequest.getSeatIds()){
            if(alreadyBookedSeat.contains(seatId)){
                throw new RuntimeException("Seat with id "+seatId+" already booked");
            }
        }

        List<Seat> seats =seatRepository.findAllById(bookingRequest.getSeatIds());
        if(seats.size() != bookingRequest.getSeatIds().size()){
            throw new RuntimeException("Some Seats are invalid");
        }

        double totalPrice = seats.size() * show.getTicketPrice();

        Booking booking = Booking.builder()
                .user(user)
                .show(show)
                .seats(seats)
                .totalPrice(totalPrice)
                .status(BookingStatus.CONFIRMED)
                .build();

        return bookingRepository.save(booking);
    }

    public Booking getBookingById(Long id){
        return bookingRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Booking not found with id : "+String.valueOf(id)));
    }

    public List<Booking> getBookingByUserId(Long userId){
        return bookingRepository.findByUserId(userId);
    }

    public Booking cancelBooking(Long bookingId){
        Booking booking = getBookingById(bookingId);
        booking.setStatus(BookingStatus.CANCELLED);
        return bookingRepository.save(booking);
    }

    public List<Seat> getAvailableSeats(Long showId){
        Show show = showService.getShowById(showId);
        List<Seat> allSeat = seatRepository.findByScreenId(show.getScreen().getId());
        List<Long> bookedSeatIds = bookingRepository.findBookedSeatIdsByShowId(showId);
        return allSeat.stream()
                .filter(seat->!bookedSeatIds.contains(seat.getId()))
                .toList();
    }

}

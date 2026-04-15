package com.bookmyshow.BookMyShow.repository;

import com.bookmyshow.BookMyShow.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,Long> {
    List<Booking> findByUserId(Long userId);
    List<Booking> findByShowId(Long showId);

    @Query("SELECT s.id FROM Booking b join b.seats s WHERE b.show.id = :showId AND b.status = 'CONFIRMED'")
    List<Long> findBookedSeatIdsByShowId(@Param("showId") Long showId);
}

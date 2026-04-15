package com.bookmyshow.BookMyShow.repository;

import com.bookmyshow.BookMyShow.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TheaterRepository extends JpaRepository<Theater, Long> {
    List<Theater> findByCityId(Long cityId);
    boolean existsById(Long id);
}

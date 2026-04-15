package com.bookmyshow.BookMyShow.repository;

import com.bookmyshow.BookMyShow.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {

    //public City findById(Long id);
    public List<City> findByNameContainingIgnoreCase(String name);

    @Query("SELECT c.state FROM City c WHERE c.state = :stateName")
    public List<City> findByStateNameContainingIgnoreCase(@Param("stateName") String stateName);
}

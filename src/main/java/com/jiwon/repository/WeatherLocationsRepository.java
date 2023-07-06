package com.jiwon.repository;

import com.jiwon.domain.WeatherLocations;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WeatherLocationsRepository extends JpaRepository<WeatherLocations,Long> {

    @Query("SELECT DISTINCT wl.dept1 FROM WeatherLocations wl")
    List<String> findDistinctDept1();

    @Query("SELECT DISTINCT wl.dept2 FROM WeatherLocations wl WHERE dept1 = '서울특별시'")
    List<String> findDistinctDept2ByDept1(String dept1);

    @Query("SELECT DISTINCT wl.dept3 FROM WeatherLocations wl WHERE dept2 = '마포구'")
    List<String> findDistinctDept3ByDept1AndDept2(String dept1, String dept2);

}

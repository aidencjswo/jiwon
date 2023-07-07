package com.jiwon.repository;

import com.jiwon.domain.WeatherLocations;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface WeatherLocationsRepository extends JpaRepository<WeatherLocations,Long> {

    @Query("SELECT DISTINCT wl.dept1 FROM WeatherLocations wl")
    List<String> findDistinctDept1();

    @Query("SELECT DISTINCT wl.dept2 FROM WeatherLocations wl WHERE dept1 = :dept1")
    List<String> findDistinctDept2ByDept1(@Param("dept1")String dept1);

    @Query("SELECT DISTINCT wl.dept3 FROM WeatherLocations wl WHERE dept1 = :dept1 and dept2 = :dept2")
    List<String> findDistinctDept3ByDept1AndDept2(@Param("dept1") String dept1, @Param("dept2") String dept2);

    @Query("SELECT nx as nx,ny as ny FROM WeatherLocations wl WHERE dept1 = :dept1 and dept2 = :dept2 and dept3 = :dept3")
    Map<String,String> findNxNy(@Param("dept1") String dept1, @Param("dept2") String dept2,@Param("dept3")String dept3);
}

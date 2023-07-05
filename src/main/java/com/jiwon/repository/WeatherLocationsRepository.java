package com.jiwon.repository;

import com.jiwon.domain.WeatherLocations;
import org.springframework.data.jpa.repository.JpaRepository;


public interface WeatherLocationsRepository extends JpaRepository<WeatherLocations,String> {

}

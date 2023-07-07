package com.jiwon.service;

import com.google.gson.JsonObject;
import com.jiwon.domain.WeatherLocations;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public interface WeatherService {

    List<WeatherLocations> selectLocations();

    List<String> selectLocationsDept1();
    Object selectLocationsDept2(String dept1);

    Object selectLocationsDept3(Map<String,String> selectMap);

    Object showWeather(Map<String, String> selectMap) throws IOException;
}

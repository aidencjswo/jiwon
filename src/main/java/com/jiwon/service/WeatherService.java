package com.jiwon.service;

import com.google.gson.JsonObject;
import com.jiwon.domain.WeatherLocations;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WeatherService {

    List<WeatherLocations> selectLocations();

    List<String> selectLocationsDeps1();
}

package com.jiwon.serviceImpl;

import com.google.gson.JsonObject;
import com.jiwon.domain.WeatherLocations;
import com.jiwon.repository.WeatherLocationsRepository;
import com.jiwon.service.WeatherService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@RequiredArgsConstructor
@Log4j2
public class WeatherServiceImpl implements WeatherService {

    private final WeatherLocationsRepository weatherLocationsRepository;

    @Override
    public List<WeatherLocations> selectLocations() {
        int page = 1;
        int size = 10;

        Pageable pageable = PageRequest.of(page, size, Sort.by("dept1").descending());

        Page<WeatherLocations> result = weatherLocationsRepository.findAll(pageable);

        List<WeatherLocations> list = result.getContent();

        list.forEach(weatherLocations -> log.info(weatherLocations));

        return list;
    }

    @Override
    public List<String> selectLocationsDeps1() {
        List<String> list = weatherLocationsRepository.findDistinctDept1();
        return list;
    }
}

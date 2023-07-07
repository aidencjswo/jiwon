package com.jiwon.repository;


import com.jiwon.domain.WeatherLocations;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
@Log4j2
public class WeatherLocationsRepositoryTests {

    @Autowired
    private WeatherLocationsRepository weatherLocationsRepository;
    @Test
    void selectLocations(){

        int page = 0;
        int size = 10;

        Pageable pageable = PageRequest.of(page, size, Sort.by("dept1").descending());

        Page<WeatherLocations> result = weatherLocationsRepository.findAll(pageable);

        List<WeatherLocations> list = result.getContent();

        list.forEach(weatherLocations -> log.info(weatherLocations));
    }

    @Test
    void selectDeptLocations(){
        List<String> list = weatherLocationsRepository.findDistinctDept1();

        log.info(list);
    }
}

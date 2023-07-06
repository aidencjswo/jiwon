package com.jiwon.controller;

import com.google.gson.JsonObject;
import com.jiwon.domain.ResultModel;
import com.jiwon.domain.WeatherLocations;
import com.jiwon.service.WeatherService;
import com.jiwon.serviceImpl.WeatherServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.coyote.Response;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@Log4j2
@Controller
@RequestMapping("/weather")
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/locations")
    public ResponseEntity selectWeatherLocations() throws ParseException {

        List<WeatherLocations> result = weatherService.selectLocations();

        ResultModel resultModel = new ResultModel();

        resultModel.setData(result);

        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/locations/dept1")
    public ResponseEntity selectLocationsDept1(){

        List<String> result = weatherService.selectLocationsDeps1();

        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/locations/dept2")
    public ResponseEntity selectLocationsDept2(
            @RequestParam("dept1")String dept1
    ){
        ResultModel resultModel = new ResultModel();
        log.info(dept1);
        return ResponseEntity.ok().body(resultModel);
    }
}

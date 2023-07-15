package com.jiwon.controller;

import com.jiwon.common.InterfaceUtilsImpl;
import com.jiwon.domain.Bus;
import com.jiwon.repository.BusRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
@Log4j2
public class BusControllerTests {

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private InterfaceUtilsImpl interfaceUtils;

    @Test
    void busRouteIdInsert() throws IOException {
        String url = "http://openapi.seoul.go.kr:8088/47696f6a7061616e39316d67426c42/json/busRoute/1/1000/";

        String resultString = interfaceUtils.get(url);

        JacksonJsonParser jacksonJsonParser = new JacksonJsonParser();

        Map<String,Object> map = jacksonJsonParser.parseMap(resultString);
        Map<String, Object> resultMap = (Map<String, Object>) map.get("busRoute");
        List<Map<String,String>> rowMap = (List<Map<String, String>>) resultMap.get("row");

        List<Bus> busList = new ArrayList<>();
        for(Map<String,String> tm : rowMap){
            Bus bus = Bus.builder()
                    .route(tm.get("ROUTE"))
                    .routeId(tm.get("ROUTE_ID"))
                    .build();
            busList.add(bus);
        }
        List<Bus> result = busRepository.saveAll(busList);
    }

    @Test
    void getBusRouteId() throws IOException {
        String url = "http://openapi.seoul.go.kr:8088/47696f6a7061616e39316d67426c42/json/busRoute/1/1000/";

        String result = interfaceUtils.get(url);

        JacksonJsonParser jacksonJsonParser = new JacksonJsonParser();

        Map<String,Object> map = jacksonJsonParser.parseMap(result);

        Map<String, Object> resultMap = (Map<String, Object>) map.get("busRoute");

        List<Map<String,String>> rowMap = (List<Map<String, String>>) resultMap.get("row");

        log.info("resultMap:"+resultMap);
        log.info("rowMap:"+rowMap);
    }
}

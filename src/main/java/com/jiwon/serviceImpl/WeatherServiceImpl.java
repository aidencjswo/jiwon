package com.jiwon.serviceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.jiwon.common.InterfaceUtilsImpl;
import com.jiwon.constants.WeatherEnum;
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

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Data
@RequiredArgsConstructor
@Log4j2
public class WeatherServiceImpl implements WeatherService {

    private final WeatherLocationsRepository weatherLocationsRepository;

    private final InterfaceUtilsImpl interfaceUtilsImpl;

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
    public List<String> selectLocationsDept1() {
        List<String> list = weatherLocationsRepository.findDistinctDept1();
        return list;
    }

    @Override
    public Object selectLocationsDept2(String dept1) {
        List<String> list = weatherLocationsRepository.findDistinctDept2ByDept1(dept1);
        log.info(list);
        return list;
    }

    @Override
    public Object selectLocationsDept3(Map<String,String> selectMap) {
        List<String> list = weatherLocationsRepository.findDistinctDept3ByDept1AndDept2(selectMap.get("dept1"),selectMap.get("dept2"));
        log.info(list);
        return list;
    }

    @Override
    public Object showWeather(Map<String, String> selectMap) throws IOException {
        Map<String,String> nxNyMap = weatherLocationsRepository.findNxNy(selectMap.get("dept1"),selectMap.get("dept2"),selectMap.get("dept3"));
        log.info(nxNyMap);

        String[] arr = new String[]{"02","05","08","11","14","17","20","23"};

        LocalDateTime current = LocalDateTime.now();

        DateTimeFormatter dtfDt = DateTimeFormatter.ofPattern("yyyyMMdd");
        DateTimeFormatter dtfTm = DateTimeFormatter.ofPattern("HH");

        String currentDt = dtfDt.format(current);
        String currentTm = dtfTm.format(current);

        String inputTm = "";

        for(int i = 0 ; i<arr.length;i++){
            if(arr[i].equals(currentTm)){
                inputTm = arr[i];
            }else if(i==arr.length-1 && !arr[i].equals(currentTm)){
                for(String s : arr){
                    if(Integer.parseInt(s)<Integer.parseInt(currentTm)){
                        inputTm = s;
                    }else if(currentTm.equals("00") || currentTm.equals("01")){
                        current = current.minusDays(1);
                        currentDt = dtfDt.format(current);
                        inputTm = "23";
                        break;
                    }
                }
            }
        }
        inputTm = inputTm.concat("00");

        String url = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst";

        Map<String, String> queryMap = new HashMap<>();
        queryMap.put("serviceKey","DPIuYVy5zN4v0C3P2PBz%2Bter9qkJwZs4J3n7lP0Kaq3%2Bldk306fe9%2FwdDelF%2FxA33%2BLsMkuS48y%2BWiYdArYYaQ%3D%3D");
        queryMap.put("numOfRows", "12");
        queryMap.put("pageNo","1");
        queryMap.put("base_date",currentDt);
        queryMap.put("base_time", inputTm);
        queryMap.put("nx", nxNyMap.get("nx"));
        queryMap.put("ny", nxNyMap.get("ny"));
        queryMap.put("dataType", "json");


        String result = interfaceUtilsImpl.get(url,queryMap);

        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> map = mapper.readValue(result, Map.class);

        Map<String,Object> responseMap = (Map<String, Object>) map.get("response");

        Map<String,Object> bodyMap = (Map<String, Object>) responseMap.get("body");

        Map<String,Object> itemsMap = (Map<String, Object>) bodyMap.get("items");

        List<Map<String,Object>> itemList = (List<Map<String, Object>>) itemsMap.get("item");

        List<String> resultList = new ArrayList<>();

        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy년MM월dd일 HH시mm분");
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyyMMddHHmm");

        String temp = itemList.get(0).get("baseDate")+""+itemList.get(0).get("baseTime");
        LocalDateTime ldt = LocalDateTime.parse(temp, dtf2);
        resultList.add("-----------------------------------------");
        resultList.add(selectMap.get("dept1")+" "+selectMap.get("dept2")+" "+selectMap.get("dept3"));
        resultList.add("-----------------------------------------");
        resultList.add(dtf1.format(ldt));
        resultList.add("-----------------------------------------");

        for(Map<String,Object> m : itemList){
            resultList.add(WeatherEnum.getKoreanByLabel(m.get("category").toString().toUpperCase())+":"+m.get("fcstValue"));
            resultList.add("-----------------------------------------");
        }

        return resultList;
    }
}

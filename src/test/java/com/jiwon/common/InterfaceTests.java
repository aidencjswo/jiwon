package com.jiwon.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.jiwon.constants.WeatherEnum;
import com.mysql.cj.xdevapi.JsonString;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.json.JSONObject;
import org.json.JSONString;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.beans.XMLDecoder;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@SpringBootTest
public class InterfaceTests {

    @Autowired
    private InterfaceUtilsImpl interfaceUtilsImpl;

    @Test
    void test1() throws IOException {

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
                        inputTm = "23";
                    }
                }
            }
        }
        inputTm = inputTm.concat("00");

        String url = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst";

        Map<String, String> queryMap = new HashMap<>();
        queryMap.put("serviceKey","DPIuYVy5zN4v0C3P2PBz%2Bter9qkJwZs4J3n7lP0Kaq3%2Bldk306fe9%2FwdDelF%2FxA33%2BLsMkuS48y%2BWiYdArYYaQ%3D%3D");
        queryMap.put("numOfRows", "14");
        queryMap.put("pageNo","1");
        queryMap.put("base_date",currentDt);
        queryMap.put("base_time", inputTm);
        queryMap.put("nx", "59");
        queryMap.put("ny", "126");
        queryMap.put("dataType", "JSON");


        String result = interfaceUtilsImpl.get(url,queryMap);

        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> map = mapper.readValue(result, Map.class);

        Map<String,Object> responseMap = (Map<String, Object>) map.get("response");

        Map<String,Object> bodyMap = (Map<String, Object>) responseMap.get("body");

        Map<String,Object> itemsMap = (Map<String, Object>) bodyMap.get("items");

        List<Map<String,Object>> itemList = (List<Map<String, Object>>) itemsMap.get("item");

        for(Map<String,Object> m : itemList){

            log.info(m.get("fcstDate")+" "+m.get("fcstTime"));
            log.info(WeatherEnum.getKoreanByLabel(m.get("category").toString().toUpperCase())+":"+m.get("fcstValue"));
            log.info("----------------------------------------");
        }
    }
}

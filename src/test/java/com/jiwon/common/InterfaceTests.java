package com.jiwon.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
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

import java.beans.XMLDecoder;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Log4j2
@SpringBootTest
public class InterfaceTests {

    @Autowired
    private InterfaceUtils interfaceUtils;

    @Test
    void test1() throws IOException {
        Date date = new Date();

        date.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String current = sdf.format(date.getTime());

        String url = "https://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst?serviceKey=DPIuYVy5zN4v0C3P2PBz%2Bter9qkJwZs4J3n7lP0Kaq3%2Bldk306fe9%2FwdDelF%2FxA33%2BLsMkuS48y%2BWiYdArYYaQ%3D%3D&numOfRows=1&pageNo=1&base_date=20230704&base_time=1749&nx=55&ny=127&dataType=JSON";

        String result = interfaceUtils.get(url);

        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> map = mapper.readValue(result, Map.class);

        Map<String,Object> responseMap = (Map<String, Object>) map.get("response");

        Map<String,Object> bodyMap = (Map<String, Object>) responseMap.get("body");

        Map<String,Object> itemsMap = (Map<String, Object>) bodyMap.get("items");

        List<Map<String,Object>> itemList = (List<Map<String, Object>>) itemsMap.get("item");

        for(Map<String,Object> m : itemList){
             for (String s : m.keySet()){
                 log.info(s+":"+m.get(s));
             }
        }
    }
}

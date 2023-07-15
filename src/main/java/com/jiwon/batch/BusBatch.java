package com.jiwon.batch;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.jiwon.common.InterfaceUtilsImpl;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class BusBatch {

    private final InterfaceUtilsImpl interfaceUtils;

    public void saveBusRoutes() throws IOException {

        String url = "http://openapi.seoul.go.kr:8088/47696f6a7061616e39316d67426c42/json/busRoute/1/1000/";

        String result = interfaceUtils.get(url);

        JacksonJsonParser jacksonJsonParser = new JacksonJsonParser();

        Map<String,Object> map = jacksonJsonParser.parseMap(result);
    }
}

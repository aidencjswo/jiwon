package com.jiwon.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.beans.XMLDecoder;
import java.io.IOException;

@Log4j2
@SpringBootTest
public class InterfaceTests {

    @Autowired
    private InterfaceUtils interfaceUtils;

    @Test
    void test1() throws IOException {
        String url = "https://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst?serviceKey=DPIuYVy5zN4v0C3P2PBz%2Bter9qkJwZs4J3n7lP0Kaq3%2Bldk306fe9%2FwdDelF%2FxA33%2BLsMkuS48y%2BWiYdArYYaQ%3D%3D&numOfRows=1&pageNo=1&base_date=20230704&base_time=1749&nx=55&ny=127";

        String xml = interfaceUtils.get(url);

        XmlMapper xmlMapper = new XmlMapper();

        ObjectMapper jsonMapper = new ObjectMapper();

        String json = jsonMapper.writeValueAsString(xmlMapper.readTree(xml));



    }
}

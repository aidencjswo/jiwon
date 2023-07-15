package com.jiwon.serviceImpl;

import com.jiwon.domain.Bus;
import com.jiwon.repository.BusRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@Log4j2
public class BusServiceImplTests {

    @Autowired
    private BusRepository busRepository;

    @Test
    void searchRouteId(){

        Bus result = busRepository.findById("중랑013").orElse(Bus.builder().routeId("잘 못된 버스 아이디 입니다.").build());

        log.info(result.getRouteId());
    }

}

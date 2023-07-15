package com.jiwon.serviceImpl;

import com.jiwon.domain.Bus;
import com.jiwon.repository.BusRepository;
import com.jiwon.service.BusService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Log4j2
public class BusServiceImpl implements BusService {

    private final BusRepository busRepository;

    @Override
    public String searchRouteId(String route) {

        Bus result = busRepository.findById(route).orElse(Bus.builder().routeId("잘 못된 버스 아이디 입니다.").build());

        log.info(result.getRouteId());

        return result.getRouteId();
    }
}

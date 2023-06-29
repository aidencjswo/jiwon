package com.jiwon.serviceImpl;

import com.jiwon.service.SampleService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Log4j2
@Repository
public class SampleServiceImpl implements SampleService {
    @Override
    public void serviceTest() {
        log.info("jenkins test");
        log.info("jenkins build test ");
        log.info("jenkins build test - 2");
    }
}

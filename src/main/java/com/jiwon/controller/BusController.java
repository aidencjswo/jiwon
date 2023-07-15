package com.jiwon.controller;

import com.jiwon.common.InterfaceUtilsImpl;
import com.jiwon.domain.ResultModel;
import com.jiwon.service.BusService;
import com.jiwon.serviceImpl.BusServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Data
@Log4j2
public class BusController {
    private final InterfaceUtilsImpl interfaceUtils;
    private final BusService busService;

    @PostMapping(value = "/bus")
    public ResponseEntity searchRouteId(
            @RequestBody Map<String,String> selectMap
    ){
        ResultModel resultModel = new ResultModel();

        log.info(selectMap.get("route"));

        String routeId = busService.searchRouteId(selectMap.get("route"));

        resultModel.setData(routeId);

        return ResponseEntity.ok().body(routeId);
    }
}

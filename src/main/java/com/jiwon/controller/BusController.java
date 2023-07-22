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
@RequestMapping("/bus")
public class BusController {
    private final InterfaceUtilsImpl interfaceUtils;
    private final BusService busService;

    @PostMapping("/routeId")
    public ResponseEntity searchRouteIdByRoute(
            @RequestBody(required = false) Map<String,Object> selectMap
    ){
        ResultModel resultModel = new ResultModel();

        log.info(selectMap.get("route"));

        String route = selectMap.get("route").toString();

        String routeId = busService.searchRouteId(route);

        resultModel.setData(routeId);

        return ResponseEntity.ok().body(resultModel);
    }

    @GetMapping("/info")
    public ResponseEntity searchInfoByRouteId(){
        ResultModel resultModel = new ResultModel();




        return ResponseEntity.ok().body("result");
    }
}

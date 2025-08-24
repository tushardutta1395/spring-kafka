package com.dailycodebuffer.cab_book_driver.controller;

import com.dailycodebuffer.cab_book_driver.service.CabLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static java.lang.Thread.sleep;

@RestController
@RequestMapping("/api/v1")
public class CabLocationController {

    @Autowired
    private CabLocationService cabLocationService;

    @PutMapping("/location")
    public ResponseEntity<?> updateLocation() throws InterruptedException {

        int range = 100;
        while (range > 0) {
            cabLocationService.updateLocation(Math.random() + ", " + Math.random());
            sleep(1000);
            range--;
        }
        return ResponseEntity.ok(Map.of("message", "Location Updated"));
    }
}

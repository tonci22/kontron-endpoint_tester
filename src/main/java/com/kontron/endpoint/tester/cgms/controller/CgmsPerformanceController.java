package com.kontron.endpoint.tester.cgms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${app.cgms.performance.controller-path}")
@ConditionalOnProperty(name = "app.cgms.performance.controller-enabled", havingValue = "true")
public class CgmsPerformanceController {
    private static final Logger log = LoggerFactory.getLogger(CgmsPerformanceController.class);


    @PostMapping("/statistics")
    public ResponseEntity<String> getCgmsAlarmPost(@RequestBody String alarmPayload) {
       return getInfo(alarmPayload);
    }

    @PutMapping("/statistics")
    public ResponseEntity<String> getCgmsAlarmPut(@RequestBody String alarmPayload) {
        return getInfo(alarmPayload);
    }

    private static ResponseEntity<String> getInfo(String alarmPayload) {
        if (alarmPayload == null || alarmPayload.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        log.info("Received CGMS performance management:\n{}", alarmPayload);

        return ResponseEntity.ok().build();
    }
}

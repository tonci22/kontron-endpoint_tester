package com.kontron.endpoint.tester.kms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/cnms/sbi/vnf/kms")
@ConditionalOnProperty(name = "app.kms.controller-enabled", havingValue = "true")
public class KmsPerformanceController {
    private static final Logger log = LoggerFactory.getLogger(KmsPerformanceController.class);


    @PostMapping("/statistics")
    public ResponseEntity<String> getKmsAlarmPost(@RequestBody String alarmPayload) {
        if (alarmPayload == null || alarmPayload.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        log.info("Received KMS performance management:\n{}", alarmPayload);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/statistics")
    public ResponseEntity<String> getKmsAlarmPut(@RequestBody String alarmPayload) {
        if (alarmPayload == null || alarmPayload.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        log.info("Received KMS performance management:\n{}", alarmPayload);

        return ResponseEntity.ok().build();
    }
}

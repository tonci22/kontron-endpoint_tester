package com.kontron.endpoint.tester.kms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${app.kms.alarms.controller-path}")
@ConditionalOnProperty(name = "app.kms.alarms.controller-enabled", havingValue = "true")
public class KmsAlarmsController {
    private static final Logger log = LoggerFactory.getLogger(KmsAlarmsController.class);


    @PostMapping("/alarms")
    public ResponseEntity<String> getKmsAlarmPost(@RequestBody String alarmPayload) {
        return getInfo(alarmPayload);
    }

    @PutMapping("/alarms")
    public ResponseEntity<String> getKmsAlarmPut(@RequestBody String alarmPayload) {
       return getInfo(alarmPayload);
    }

    private static ResponseEntity<String> getInfo(String alarmPayload) {
        if (alarmPayload == null || alarmPayload.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        log.info("Received KMS alarm:\n{}", alarmPayload);

        return ResponseEntity.ok().build();
    }
}

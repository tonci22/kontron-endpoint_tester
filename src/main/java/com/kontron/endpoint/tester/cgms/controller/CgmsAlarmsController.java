package com.kontron.endpoint.tester.cgms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/cnms/sbi/vnf/cgms")
@ConditionalOnProperty(name = "app.cgms.controller-enabled", havingValue = "true")
public class CgmsAlarmsController {
    private static final Logger log = LoggerFactory.getLogger(CgmsAlarmsController.class);

    @PostMapping("/alarms")
    public ResponseEntity<String> getCgmsAlarmPost(@RequestBody String alarmPayload) {
        if (alarmPayload == null || alarmPayload.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        log.info("Received CGMS alarm:\n{}", alarmPayload);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/alarms")
    public ResponseEntity<String> getCgmsAlarmPut(@RequestBody String alarmPayload) {
        if (alarmPayload == null || alarmPayload.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        log.info("Received CGMS alarm:\n{}", alarmPayload);

        return ResponseEntity.ok().build();
    }
}

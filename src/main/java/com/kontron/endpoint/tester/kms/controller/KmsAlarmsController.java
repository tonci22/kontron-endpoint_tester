package com.kontron.endpoint.tester.kms.controller;

import com.kontron.endpoint.tester.config.KmsProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("${app.kms.alarms.controller-path}")
@ConditionalOnProperty(name = "app.kms.alarms.controller-enabled", havingValue = "true")
public class KmsAlarmsController {
    private static final String ALARM_ENDPOINT = "/alarms";

    private final KmsProperties properties;

    @PostMapping(ALARM_ENDPOINT)
    public ResponseEntity<String> getKmsAlarmPost(@RequestBody String alarmPayload) {
        return getInfo(alarmPayload);
    }

    @PutMapping(ALARM_ENDPOINT)
    public ResponseEntity<String> getKmsAlarmPut(@RequestBody String alarmPayload) {
       return getInfo(alarmPayload);
    }

    private ResponseEntity<String> getInfo(String alarmPayload) {
        if (alarmPayload == null || alarmPayload.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        log.info("Received KMS alarm ({}):\n{}", properties.getAlarmControllerUrl() + ALARM_ENDPOINT, alarmPayload);

        return ResponseEntity.ok().build();
    }
}

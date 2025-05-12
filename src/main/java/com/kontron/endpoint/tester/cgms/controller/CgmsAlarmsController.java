package com.kontron.endpoint.tester.cgms.controller;

import com.kontron.endpoint.tester.config.CgmsProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("${app.cgms.alarms.controller-path}")
@ConditionalOnProperty(name = "app.cgms.alarms.controller-enabled", havingValue = "true")
public class CgmsAlarmsController {
    private static final String ALARM_ENDPOINT = "/alarms";

    private final CgmsProperties properties;

    @PostMapping(ALARM_ENDPOINT)
    public ResponseEntity<String> getCgmsAlarmPost(@RequestBody String alarmPayload) {
        return getInfo(alarmPayload);
    }

    @PutMapping(ALARM_ENDPOINT)
    public ResponseEntity<String> getCgmsAlarmPut(@RequestBody String alarmPayload) {
        return getInfo(alarmPayload);
    }

    private ResponseEntity<String> getInfo(String alarmPayload) {
        if (alarmPayload == null || alarmPayload.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        log.info("Received CGMS alarm ({}):\n{}", properties.getAlarmControllerUrl() + ALARM_ENDPOINT, alarmPayload);
        return ResponseEntity.ok().build();
    }
}

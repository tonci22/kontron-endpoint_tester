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
@RequestMapping("${app.cgms.performance.controller-path}")
@ConditionalOnProperty(name = "app.cgms.performance.controller-enabled", havingValue = "true")
public class CgmsPerformanceController {

    private static final String PM_ENDPOINT = "/statistics";

    private final CgmsProperties properties;

    @PostMapping(PM_ENDPOINT)
    public ResponseEntity<String> getCgmsAlarmPost(@RequestBody String performancePayload) {
       return getInfo(performancePayload);
    }

    @PutMapping(PM_ENDPOINT)
    public ResponseEntity<String> getCgmsAlarmPut(@RequestBody String performancePayload) {
        return getInfo(performancePayload);
    }

    private ResponseEntity<String> getInfo(String performancePayload) {
        if (performancePayload == null || performancePayload.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        log.info("Received CGMS performance management ({}):\n{}", properties.getPerformanceControllerUrl() + PM_ENDPOINT, performancePayload);

        return ResponseEntity.ok().build();
    }
}

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
@RequestMapping("${app.kms.performance.controller-path}")
@ConditionalOnProperty(name = "app.kms.performance.controller-enabled", havingValue = "true")
public class KmsPerformanceController {
    private static final String PM_ENDPOINT = "/statistics";

    private final KmsProperties properties;

    @PostMapping(PM_ENDPOINT)
    public ResponseEntity<String> getKmsAlarmPost(@RequestBody String performancePayload) {
        return getInfo(performancePayload);
    }

    @PutMapping(PM_ENDPOINT)
    public ResponseEntity<String> getKmsAlarmPut(@RequestBody String performancePayload) {
        return getInfo(performancePayload);
    }

    private ResponseEntity<String> getInfo(String performancePayload) {
        if (performancePayload == null || performancePayload.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        log.info("Received KMS performance management ({}):\n{}", properties.getPerformanceControllerUrl() + PM_ENDPOINT, performancePayload);

        return ResponseEntity.ok().build();
    }
}

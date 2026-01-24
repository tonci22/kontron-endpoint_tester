package com.kontron.endpoint.tester.cgms.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/rest")
public class CgmsDbSyncController {

    @PostMapping("/dbsync")
    public ResponseEntity<String> getDocumentEvent(@RequestBody String event) {
        log.info("Received CGMS DB Sync event:\n{}", event);
        return ResponseEntity.ok(event);
    }
}

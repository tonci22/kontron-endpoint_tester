package com.kontron.endpoint.tester.cgms.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/rest")
public class CgmsDbSyncController {

    @PostMapping(value = "/dbsync", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> getDocumentEvent(@RequestPart("metadata") String metadata,
                                                   @RequestPart(value = "oldXmlDocumentEvent", required = false) String oldXmlDocumentEvent,
                                                   @RequestPart(value = "newXmlDocumentEvent", required = false) String newXmlDocumentEvent) {
        log.info("Received CGMS DB Sync event:\nmetadata: {}\noldXmlDocumentEvent: {}\nnewXmlDocumentEvent: {}", metadata, oldXmlDocumentEvent, newXmlDocumentEvent);
        return ResponseEntity.ok().build();
    }
}

package com.neeraj.tinyurl.controller;

import com.neeraj.tinyurl.service.IdGenerationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ids")
@Slf4j
public class IDGenerationController {

    @Autowired
    private IdGenerationService idGenerationService;

    @GetMapping
    public ResponseEntity<String> getId(@PathVariable("serviceName") String serviceName){
        String id = idGenerationService.getId(serviceName);
        log.info("Sending message to kafka: " + id);
        return ResponseEntity.ok(id);
    }
}

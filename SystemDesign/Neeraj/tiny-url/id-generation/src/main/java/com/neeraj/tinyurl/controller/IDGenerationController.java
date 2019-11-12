package com.neeraj.tinyurl.controller;

import com.neeraj.tinyurl.service.IdGenerationService;
import com.neeraj.tinyurl.service.KafkaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ids")
@Slf4j
public class IDGenerationController {

    @Autowired
    private IdGenerationService idGenerationService;

    @Autowired
    private KafkaService kafkaService;

    @GetMapping
    public ResponseEntity<String> getId(){
        String id = idGenerationService.getId();
        log.info("Sending message to kafka: " + id);
        kafkaService.sendMessage(id);
        return ResponseEntity.ok(id);
    }
}

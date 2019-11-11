package com.neeraj.tinyurl.controller;

import com.neeraj.tinyurl.service.IdGenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ids")
public class IDGenerationController {

    @Autowired
    private IdGenerationService idGenerationService;

    @GetMapping
    public ResponseEntity<String> getId(){
        String id = idGenerationService.getId();
        return ResponseEntity.ok(id);
    }
}

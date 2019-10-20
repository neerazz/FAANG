package com.sachi.micro.tinyurl.controller;

import com.sachi.micro.tinyurl.exception.ResourceNotFoundException;
import com.sachi.micro.tinyurl.model.TinyURL;
import com.sachi.micro.tinyurl.model.TinyURLDTO;
import com.sachi.micro.tinyurl.service.URLService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@RestController
@Slf4j
public class TinyURLController {

    private final URLService urlService;

    @Autowired
    public TinyURLController(URLService urlService) {
        log.debug("Instantiating  Controller");
        this.urlService = urlService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TinyURLDTO>> getAll() {
        log.debug("All");
        return ResponseEntity.ok().body(urlService.getAll());
    }

    @GetMapping("/{shortCode}")
    public RedirectView expandURL(@PathVariable(value = "shortCode")
                                  @NotBlank @Size(max = 16, message = "Bad Request.")
                                          String shortCode)
            throws ResourceNotFoundException {
        TinyURL tinyURL = urlService.getURLById(shortCode);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(tinyURL.getLongURL());
        return redirectView;
    }

    @PostMapping("/minify")
    public ResponseEntity<TinyURLDTO> minifyURL(@Valid @RequestBody TinyURLDTO input) {
        log.debug("Minify");
        return ResponseEntity.ok().body(urlService.getShortURL(input.getLongURL(), input.getUserId()));
    }
}


package com.sachi.micro.tinyurl.controller;

import com.sachi.micro.tinyurl.data.model.URL;
import com.sachi.micro.tinyurl.data.repo.URLRepository;
import com.sachi.micro.tinyurl.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TinyURLController {

    @Autowired
    private URLRepository URLRepository;

    @GetMapping("/all")
    public List<URL> getAllURLs() {
        return URLRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<URL> getURLById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        URL URL = URLRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("URL not found for this id : " + id));
        return ResponseEntity.ok().body(URL);
    }

    @PostMapping("/shorten")
    public URL shortenURL(@RequestBody String longURL) {
        URL url = new URL();
        url.setShortURL("http://lol");
        url.setLongURL(longURL);
        return URLRepository.save(url);
    }


    /*@PostMapping("/employee
    public URL createEmployee(@Valid @RequestBody URL URL) {
        return URLRepository.save(URL);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<URL> updateEmployee(@PathVariable(value = "id") Long employeeId,
                                              @Valid @RequestBody URL URLDetails) throws ResourceNotFoundException {
        URL URL = URLRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        final URL updatedURL = URLRepository.save(URL);
        return ResponseEntity.ok(updatedURL);
    }

    @DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {
        URL URL = URLRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        URLRepository.delete(URL);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }*/
}


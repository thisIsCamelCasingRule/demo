package com.example.demo.api;

import com.example.demo.domain.services.SentenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/sentence")
public class SentenceController {

    @Autowired
    private SentenceService service;

    @GetMapping(params = {"peasant", "kingdom"})
    public ResponseEntity<Boolean> executePeasant(@RequestParam String peasant, @RequestParam String kingdom)
    {
        return ResponseEntity.ok(service.execute(peasant, kingdom));
    }

    @GetMapping(params = {"peasant"})
    public ResponseEntity<Boolean> pardonPeasant(@RequestParam String peasant)
    {
        return ResponseEntity.ok(service.pardon(peasant));
    }

}

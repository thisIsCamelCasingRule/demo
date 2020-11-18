package com.example.demo.api;

import com.example.demo.domain.classes.Peasant;
import com.example.demo.domain.services.PeasantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/peasant")
public class PeasantController {

    @Autowired
    private PeasantService service;

    @PostMapping
    public ResponseEntity<Peasant> addNewPeasant(@RequestParam String name, @RequestParam String position, @RequestParam String kingdom, @RequestParam boolean status){
        return ResponseEntity.ok(service.addPeasant(name, position, kingdom, status));
    }

    @GetMapping
    public ResponseEntity<List<Peasant>> getAllPeasant()
    {
        return ResponseEntity.ok(service.allPeasant());
    }

    @GetMapping(params= {"name"})
    public ResponseEntity<Peasant> getPeasantByName(@RequestParam String name){
        return ResponseEntity.ok(service.getPeasantByName(name));
    }

    @PutMapping(params= {"name"})
    public ResponseEntity<Peasant> updatePeasant(@RequestParam String name, @RequestParam String position, @RequestParam String kingdom, @RequestParam boolean status){
        return ResponseEntity.ok(service.updatePeasant(name, position, kingdom, status));
    }

    @DeleteMapping(params= {"name"})
    public ResponseEntity<Boolean> deletePeasant(@RequestParam String name){
        return ResponseEntity.ok(service.deletePeasantByName(name));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteAllPeasant(){
        return ResponseEntity.ok(service.deleteAllPeasant());
    }
}

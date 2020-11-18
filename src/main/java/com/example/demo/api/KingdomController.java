package com.example.demo.api;

import com.example.demo.domain.classes.Kingdom;
import com.example.demo.domain.services.KingdomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/kingdom")
public class KingdomController {
    @Autowired
    private KingdomService service;

    @PostMapping
    public ResponseEntity<Kingdom> addNewKingdom(@RequestParam String name, @RequestParam double sqare, @RequestParam int population, @RequestParam int amountOfBuildings){
        return ResponseEntity.ok(service.addKingdom(name, sqare, population, amountOfBuildings));
    }

    @GetMapping
    public ResponseEntity<List<Kingdom>> getAllKingdom()
    {
        return ResponseEntity.ok(service.allKingdoms());
    }

    @GetMapping(params = {"name"})
    public ResponseEntity<Kingdom> getKingdomByName(@RequestParam String name){
        return ResponseEntity.ok(service.getKingdomByName(name));
    }

    @PutMapping(params= {"name"})
    public ResponseEntity<Kingdom> updateKingdom(@RequestParam String name, @RequestParam double sqare, @RequestParam int population, @RequestParam int amountOfBuildings){
        return ResponseEntity.ok(service.updateKingdom(name,sqare,population,amountOfBuildings));
    }

    @DeleteMapping(params= {"name"})
    public ResponseEntity<Boolean> deleteKingdom(@RequestParam String name){
        return ResponseEntity.ok(service.deleteKingdomByName(name));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteAllKingdoms(){
        return ResponseEntity.ok(service.deleteAllKingdoms());
    }

}

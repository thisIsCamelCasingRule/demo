package com.example.demo.api;

import com.example.demo.domain.classes.King;
import com.example.demo.domain.services.KingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/king")
public class KingController {
    @Autowired
    private KingService service;

    @PostMapping(params = {"name", "kingdom"})
    public ResponseEntity<King> addNewKing(@RequestParam String name, @RequestParam String kingdom){
        return ResponseEntity.ok(service.addKing(name, kingdom));
    }

    @GetMapping
    public ResponseEntity<List<King>> getAllKing()
    {
        return ResponseEntity.ok(service.allKing());
    }

    @GetMapping(params = {"name"})
    public ResponseEntity<King> getKingByName(@RequestParam String name){
        return ResponseEntity.ok(service.getKingByName(name));
    }

    @PutMapping(params = {"name"})
    public ResponseEntity<King> updateKing(@RequestParam String name, @RequestParam String kingdom){
        return ResponseEntity.ok(service.updateKing(name,kingdom));
    }

    @DeleteMapping(params= {"name"})
    public ResponseEntity<Boolean> deleteKing(@RequestParam String name){
        return ResponseEntity.ok(service.deleteKingByName(name));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteAllKing(){
        return ResponseEntity.ok(service.deleteAllKing());
    }
}

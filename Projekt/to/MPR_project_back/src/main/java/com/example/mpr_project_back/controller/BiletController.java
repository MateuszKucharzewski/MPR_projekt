package com.example.mpr_project_back.controller;


import com.example.mpr_project_back.model.Bilet;
import com.example.mpr_project_back.service.BiletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BiletController {
    private final BiletService biletService;

    @Autowired
    public BiletController(BiletService biletService) {
        this.biletService = biletService;
    }

    @GetMapping("/bilet/all")
    public ResponseEntity<List<Bilet>> getAll() {
        return new ResponseEntity<>(this.biletService.getAllBilety(), HttpStatus.OK);
    }

    @GetMapping("/bilet/name/{nameP}")
    public ResponseEntity<List<Bilet>> getByName(@PathVariable String nameP) {
        return new ResponseEntity<>(this.biletService.getBiletByNameP(nameP), HttpStatus.OK);
    }

    @GetMapping("/bilet/{id}")
    public ResponseEntity<Bilet> get(@PathVariable Long id) {
        return new ResponseEntity<>(this.biletService.get(id), HttpStatus.OK);
    }

    @PostMapping("/bilet/addBilets") // Obsługuje POST na /bilet/addBilets
    public ResponseEntity<String> addBilet(@RequestBody Bilet bilet) {
        if (bilet.getNameP() == null || bilet.getMiejsceWylotu() == null ||
                bilet.getMiejscePrzylotu() == null || bilet.getNumerSiedzenia() == null) {
            return ResponseEntity.badRequest().body("Brak wymaganych danych!");
        }
        biletService.addBilet(bilet);
        return ResponseEntity.status(HttpStatus.CREATED).body("Bilet dodany!");
    }

    @DeleteMapping("/bilet/delete/{id}")
    public ResponseEntity<Bilet> deleteBilet(@PathVariable Long id) {
        this.biletService.deleteBilet(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/bilet/update/{id}")
    public ResponseEntity<Bilet> updateBilet(@PathVariable Long id, @RequestBody Bilet bilet) {
        this.biletService.updateBilet(id, bilet);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
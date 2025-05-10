package com.ay.controller;

import com.ay.entity.Soil;
import com.ay.services.SoilService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/soils")
@CrossOrigin(origins = "http://localhost:5173")
public class SoilController {

    private final SoilService soilService;

    public SoilController(SoilService soilService) {
        this.soilService = soilService;
    }

    @PostMapping
    public ResponseEntity<Soil> addSoil(@RequestBody Soil soil) {
        return ResponseEntity.ok(soilService.addSoil(soil));
    }

    @GetMapping
    public ResponseEntity<List<Soil>> getAllSoils() {
        return ResponseEntity.ok(soilService.getAllSoils());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Soil> getSoilById(@PathVariable Long id) {
        return ResponseEntity.ok(soilService.getSoilById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Soil> updateSoil(@PathVariable Long id, @RequestBody Soil soil) {
        return ResponseEntity.ok(soilService.updateSoil(id, soil));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSoil(@PathVariable Long id) {
        soilService.deleteSoil(id);
        return ResponseEntity.ok("Soil deleted successfully");
    }
}

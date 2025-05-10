package com.ay.controller;

import com.ay.entity.ExpertConsultation;
import com.ay.services.ExpertConsultationService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/expert-consultations")
public class ExpertConsultationController {

    private final ExpertConsultationService service;

    public ExpertConsultationController(ExpertConsultationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ExpertConsultation> create(@RequestBody ExpertConsultation consultation) {
        return ResponseEntity.ok(service.saveConsultation(consultation));
    }

    @GetMapping
    public ResponseEntity<List<ExpertConsultation>> getAll() {
        return ResponseEntity.ok(service.getAllConsultations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpertConsultation> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getConsultationById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.deleteConsultation(id);
        return ResponseEntity.ok("Deleted successfully");
    }
}

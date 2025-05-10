package com.ay.controller;

import com.ay.entity.MultilingualSupport;
import com.ay.services.MultilingualSupportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class MultilingualSupportController {

    private final MultilingualSupportService service;

    public MultilingualSupportController(MultilingualSupportService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<MultilingualSupport> addLanguage(@RequestBody MultilingualSupport support) {
        return new ResponseEntity<>(service.addLanguageSupport(support), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MultilingualSupport>> getLanguages() {
        return ResponseEntity.ok(service.getAllLanguages());
    }
}

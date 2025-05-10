package com.ay.controller;

import com.ay.entity.HelplineSupport;
import com.ay.services.HelplineSupportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/helpline")
public class HelplineSupportController {

    private final HelplineSupportService helplineService;

    public HelplineSupportController(HelplineSupportService helplineService) {
        this.helplineService = helplineService;
    }

    @PostMapping
    public ResponseEntity<HelplineSupport> createQuery(@RequestBody HelplineSupport query) {
        return ResponseEntity.ok(helplineService.addQuery(query));
    }

    @GetMapping
    public ResponseEntity<List<HelplineSupport>> getAll() {
        return ResponseEntity.ok(helplineService.getAllQueries());
    }

    @PutMapping("/{id}")
    public ResponseEntity<HelplineSupport> updateStatus(@PathVariable Long id, @RequestParam String status) {
        return ResponseEntity.ok(helplineService.updateStatus(id, status));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        helplineService.deleteQuery(id);
        return ResponseEntity.ok("Query deleted successfully");
    }
}

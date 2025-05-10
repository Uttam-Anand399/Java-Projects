package com.ay.controller;

import com.ay.entity.ResourceMaterial;
import com.ay.services.ResourceMaterialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resources")
public class ResourceMaterialController {

    private final ResourceMaterialService service;

    public ResourceMaterialController(ResourceMaterialService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ResourceMaterial> addResource(@RequestBody ResourceMaterial material) {
        return ResponseEntity.ok(service.addResource(material));
    }

    @GetMapping
    public ResponseEntity<List<ResourceMaterial>> getAllResources() {
        return ResponseEntity.ok(service.getAllResources());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteResource(@PathVariable Long id) {
        service.deleteResource(id);
        return ResponseEntity.ok("Resource deleted successfully.");
    }
}

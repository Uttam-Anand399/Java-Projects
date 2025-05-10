package com.ay.controller;

import com.ay.entity.AwarenessTraining;
import com.ay.services.AwarenessTrainingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trainings")
public class AwarenessTrainingController {

    private final AwarenessTrainingService trainingService;

    public AwarenessTrainingController(AwarenessTrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @PostMapping
    public ResponseEntity<AwarenessTraining> addTraining(@RequestBody AwarenessTraining training) {
        return new ResponseEntity<>(trainingService.addTraining(training), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AwarenessTraining>> getAllTrainings() {
        return ResponseEntity.ok(trainingService.getAllTrainings());
    }
}

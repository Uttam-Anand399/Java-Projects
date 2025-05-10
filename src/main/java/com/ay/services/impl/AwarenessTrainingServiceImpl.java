package com.ay.services.impl;

import com.ay.entity.AwarenessTraining;
import com.ay.repository.AwarenessTrainingRepository;
import com.ay.services.AwarenessTrainingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AwarenessTrainingServiceImpl implements AwarenessTrainingService {

    private final AwarenessTrainingRepository trainingRepository;

    public AwarenessTrainingServiceImpl(AwarenessTrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    @Override
    public AwarenessTraining addTraining(AwarenessTraining training) {
        return trainingRepository.save(training);
    }

    @Override
    public List<AwarenessTraining> getAllTrainings() {
        return trainingRepository.findAll();
    }
}

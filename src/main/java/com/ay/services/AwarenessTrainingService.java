package com.ay.services;

import com.ay.entity.AwarenessTraining;

import java.util.List;

public interface AwarenessTrainingService {
    AwarenessTraining addTraining(AwarenessTraining training);
    List<AwarenessTraining> getAllTrainings();
}

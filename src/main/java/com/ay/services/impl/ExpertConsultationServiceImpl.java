package com.ay.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ay.entity.ExpertConsultation;
import com.ay.repository.ExpertConsultationRepository;
import com.ay.services.ExpertConsultationService;

@Service
public class ExpertConsultationServiceImpl implements ExpertConsultationService {

    private final ExpertConsultationRepository repository;

    public ExpertConsultationServiceImpl(ExpertConsultationRepository repository) {
        this.repository = repository;
    }

    @Override
    public ExpertConsultation saveConsultation(ExpertConsultation consultation) {
        return repository.save(consultation);
    }

    @Override
    public List<ExpertConsultation> getAllConsultations() {
        return repository.findAll();
    }

    @Override
    public ExpertConsultation getConsultationById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteConsultation(Long id) {
        repository.deleteById(id);
    }
}

package com.ay.services;

import java.util.List;

import com.ay.entity.ExpertConsultation;

public interface ExpertConsultationService {
	ExpertConsultation saveConsultation(ExpertConsultation consultation);
    List<ExpertConsultation> getAllConsultations();
    ExpertConsultation getConsultationById(Long id);
    void deleteConsultation(Long id);

}

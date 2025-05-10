package com.ay.services.impl;

import com.ay.entity.Soil;
import com.ay.exception.ResourceNotFoundException;
import com.ay.repository.SoilRepo;
import com.ay.services.SoilService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoilServiceImpl implements SoilService {

    private final SoilRepo soilRepository;

    public SoilServiceImpl(SoilRepo soilRepository) {
        this.soilRepository = soilRepository;
    }

    @Override
    public Soil addSoil(Soil soil) {
        return soilRepository.save(soil);
    }

    @Override
    public List<Soil> getAllSoils() {
        return soilRepository.findAll();
    }

    @Override
    public Soil getSoilById(Long id) {
        return soilRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Soil not found with id: " + id));
    }

    @Override
    public Soil updateSoil(Long id, Soil soil) {
        Soil existing = getSoilById(id);

        existing.setName(soil.getName());
        existing.setTexture(soil.getTexture());
        existing.setPHLevel(soil.getPHLevel());
        existing.setOrganicMatter(soil.getOrganicMatter());
        existing.setWaterRetention(soil.getWaterRetention());
        existing.setIdealCrops(soil.getIdealCrops());
        existing.setDescription(soil.getDescription());

        return soilRepository.save(existing);
    }

    @Override
    public void deleteSoil(Long id) {
        Soil soil = getSoilById(id);
        soilRepository.delete(soil);
    }
}

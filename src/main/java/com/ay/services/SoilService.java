package com.ay.services;

import com.ay.entity.Soil;

import java.util.List;

public interface SoilService {
    Soil addSoil(Soil soil);
    List<Soil> getAllSoils();
    Soil getSoilById(Long id);
    Soil updateSoil(Long id, Soil soil);
    void deleteSoil(Long id);
}

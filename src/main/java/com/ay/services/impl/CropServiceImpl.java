package com.ay.services.impl;

import com.ay.entity.Crop;
import com.ay.exception.ResourceNotFoundException;
import com.ay.repository.CropRepo;
import com.ay.services.CropService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CropServiceImpl implements CropService {

    private final CropRepo cropRepository;

    public CropServiceImpl(CropRepo cropRepository) {
        this.cropRepository = cropRepository;
    }

    @Override
    public Crop addCrop(Crop crop) {
        return cropRepository.save(crop);
    }

    @Override
    public List<Crop> getAllCrops() {
        return cropRepository.findAll();
    }

    @Override
    public Crop getCropById(Long id) {
        return cropRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Crop not found with id: " + id));
    }

    @Override
    public Crop updateCrop(Long id, Crop updatedCrop) {
        Crop existingCrop = getCropById(id);

        existingCrop.setName(updatedCrop.getName());
        existingCrop.setCropType(updatedCrop.getCropType());
        existingCrop.setSeason(updatedCrop.getSeason());
        existingCrop.setSoilType(updatedCrop.getSoilType());
        existingCrop.setIdealTemperature(updatedCrop.getIdealTemperature());
        existingCrop.setWaterRequirement(updatedCrop.getWaterRequirement());
        existingCrop.setFertilizers(updatedCrop.getFertilizers());
        existingCrop.setYieldPerHectare(updatedCrop.getYieldPerHectare());
        existingCrop.setImageUrl(updatedCrop.getImageUrl());

        return cropRepository.save(existingCrop);
    }

    @Override
    public void deleteCrop(Long id) {
        Crop crop = getCropById(id);
        cropRepository.delete(crop);
    }
}

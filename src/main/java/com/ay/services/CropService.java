package com.ay.services;

import com.ay.entity.Crop;

import java.util.List;

public interface CropService {
    Crop addCrop(Crop crop);
    List<Crop> getAllCrops();
    Crop getCropById(Long id);
    Crop updateCrop(Long id, Crop crop);
    void deleteCrop(Long id);
}

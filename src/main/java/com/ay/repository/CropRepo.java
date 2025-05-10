package com.ay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ay.entity.Crop;

public interface CropRepo extends JpaRepository<Crop, Long> {

}

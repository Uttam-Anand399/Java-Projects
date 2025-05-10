package com.ay.repository;

import com.ay.entity.Soil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoilRepo extends JpaRepository<Soil, Long> {
}

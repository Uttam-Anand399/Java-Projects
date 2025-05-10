package com.ay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ay.entity.EmployeeRecord;
@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeRecord, Integer>{

}

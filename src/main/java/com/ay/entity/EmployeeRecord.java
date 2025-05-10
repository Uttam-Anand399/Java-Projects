package com.ay.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Employee_Record")
public class EmployeeRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer empId;
	
	@Column(name="Employee_Name")
	private String name;
	private String desg;
	private Float salary;
	
	
}

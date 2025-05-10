package com.ay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ay.entity.Booking;

public interface BookingRepo extends JpaRepository<Booking, Long> {
	  List<Booking> findByUserId(Long userId);

}

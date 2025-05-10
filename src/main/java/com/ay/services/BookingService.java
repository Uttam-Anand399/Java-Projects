package com.ay.services;

import com.ay.entity.Booking;

import java.util.List;

public interface BookingService {
    Booking createBooking(Long userId, Booking booking);
    List<Booking> getBookingsByUser(Long userId);
    Booking getBookingById(Long id);
    void cancelBooking(Long id);
}

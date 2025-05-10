package com.ay.services.impl;

import com.ay.entity.Booking;
import com.ay.entity.User;
import com.ay.repository.BookingRepo;
import com.ay.repository.UserRepo;
import com.ay.services.BookingService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepo bookingRepository;
    private final UserRepo userRepo;

    public BookingServiceImpl(BookingRepo bookingRepository, UserRepo userRepo) {
        this.bookingRepository = bookingRepository;
        this.userRepo = userRepo;
    }

    @Override
    public Booking createBooking(Long userId, Booking booking) {
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        booking.setUser(user);
        booking.setBookingTime(LocalDateTime.now());
        booking.setStatus("Pending");
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getBookingsByUser(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    @Override
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    @Override
    public void cancelBooking(Long id) {
        Booking booking = getBookingById(id);
        booking.setStatus("Cancelled");
        bookingRepository.save(booking);
    }
}

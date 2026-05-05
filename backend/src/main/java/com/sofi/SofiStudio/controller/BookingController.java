package com.sofi.SofiStudio.controller;

import com.sofi.SofiStudio.dto.BookingDto;
import com.sofi.SofiStudio.model.Booking;
import com.sofi.SofiStudio.model.BookingStatus;
import com.sofi.SofiStudio.service.BookingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @GetMapping("admin/bookings")
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @PostMapping("/booking")
    public Booking addBooking(@Valid @RequestBody BookingDto bookingdto) {
        return bookingService.createBooking(bookingdto);
    }

    @PutMapping("/admin/bookings/{id}/status")
    public Booking updateBooking(@PathVariable Long id, @RequestParam("status") BookingStatus bookingStatus) {
        return bookingService.updateStatus(id, bookingStatus);
    }

    @DeleteMapping("/admin/bookings/{id}")
    public void deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
    }

}

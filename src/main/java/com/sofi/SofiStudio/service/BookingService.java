package com.sofi.SofiStudio.service;

import com.sofi.SofiStudio.dto.BookingDto;
import com.sofi.SofiStudio.model.Booking;
import com.sofi.SofiStudio.model.BookingStatus;

import java.util.List;

public interface BookingService {

    Booking createBooking(BookingDto dto);

    List<Booking> getAllBookings();

    Booking updateStatus(Long id, BookingStatus status);

    void  deleteBooking(Long id);

}

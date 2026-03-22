package com.sofi.SofiStudio.service;

import com.sofi.SofiStudio.dto.BookingDto;
import com.sofi.SofiStudio.model.Booking;
import com.sofi.SofiStudio.model.BookingDay;
import com.sofi.SofiStudio.model.BookingStatus;
import com.sofi.SofiStudio.repository.BookingRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepo bookingRepo;
    private final MailNotifService mailNotifService;

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepo.findAll();
    }

    @Override
    public Booking updateStatus(Long id, BookingStatus status) {
        Booking booking = bookingRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking Not Found with id: " + id));

        booking.setStatus(status);
        Booking savedBooking = bookingRepo.save(booking);

        if (status == BookingStatus.CONFIRMED) {
            mailNotifService.sendBookingConfirmationToClient(savedBooking);
        } else if (status == BookingStatus.CANCELLED) {
            mailNotifService.sendBookingCancellationToClient(savedBooking);
        }

        return savedBooking;
    }

    @Override
    public Booking createBooking(BookingDto dto) {
        Booking booking = new Booking();
        booking.setName(dto.getName());
        booking.setEmail(dto.getEmail());
        booking.setPhone(dto.getPhone());
        booking.setDescription(dto.getDescription());
        booking.setStatus(BookingStatus.PENDING);

        List<BookingDay> bookingDays = new ArrayList<>();
        for (LocalDate date: dto.getDays()) {
            BookingDay day = new BookingDay();
            day.setDate(date);
            day.setBooking(booking);
            bookingDays.add(day);
        }
        booking.setDays(bookingDays);
        Booking savedBooking = bookingRepo.save(booking);
        mailNotifService.sendBookingConfirmation(savedBooking);

        return savedBooking;
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepo.deleteById(id);
    }

}

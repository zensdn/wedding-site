package com.sofi.SofiStudio.service;

import com.sofi.SofiStudio.model.Booking;

public interface MailNotifService {
    void sendBookingConfirmation(Booking booking);

    void sendBookingConfirmationToClient(Booking booking);

    void sendBookingCancellationToClient(Booking booking);
}

package com.sofi.SofiStudio.service;

import com.sofi.SofiStudio.model.Booking;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailNotifServiceImpl implements MailNotifService {

    private final JavaMailSender mailSender;
    @Value("${app.admin-email}") private String adminEmail;

    public void sendBookingConfirmation(Booking booking) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(adminEmail);
        message.setSubject("Booking Received From " + booking.getName());
        message.setText("Check the admin panel for booking confirmation and details!");

        mailSender.send(message);
    }

    public void sendBookingConfirmationToClient(Booking booking) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(booking.getEmail());
        message.setSubject("Booking Confirmed for " + booking.getName() + " From Sofi Digital Studio!");
        message.setText("Your Booking request has been accepted!\n\n We will be contacting you soon via whatsapp.");

        mailSender.send(message);
    }

}

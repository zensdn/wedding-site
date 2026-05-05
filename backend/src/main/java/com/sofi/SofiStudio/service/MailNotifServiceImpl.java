package com.sofi.SofiStudio.service;

import com.sofi.SofiStudio.model.Booking;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MailNotifServiceImpl implements MailNotifService {

    private final JavaMailSender mailSender;
    @Value("${app.admin-email}") private String adminEmail;

    @Override
    public void sendBookingConfirmation(Booking booking) {
        String days = booking.getDays().stream()
                .map(day -> "  - " + day.getDate().toString())
                .collect(Collectors.joining("\n"));

        String body = "You have received a new booking request!\n\n" +
                "─────────────────────────────\n" +
                "CLIENT DETAILS\n" +
                "─────────────────────────────\n" +
                "Name        : " + booking.getName() + "\n" +
                "Email       : " + booking.getEmail() + "\n" +
                "Phone       : " + booking.getPhone() + "\n\n" +
                "BOOKING DETAILS\n" +
                "─────────────────────────────\n" +
                "Requested Days:\n" + days + "\n\n" +
                "Description : " + (booking.getDescription() != null && !booking.getDescription().isEmpty()
                ? booking.getDescription() : "No additional details provided") + "\n\n" +
                "─────────────────────────────\n" +
                "Please log in to the admin panel to confirm or cancel this booking.\n" +
                "The client will be notified automatically once you update the status.";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(adminEmail);
        message.setSubject("📅 New Booking Request from " + booking.getName());
        message.setText(body);
        mailSender.send(message);
    }

    @Override
    public void sendBookingConfirmationToClient(Booking booking) {
        String days = booking.getDays().stream()
                .map(day -> "  - " + day.getDate().toString())
                .collect(Collectors.joining("\n"));

        String body = "Dear " + booking.getName() + ",\n\n" +
                "We are delighted to confirm your booking with Sofi Digital Studio!\n\n" +
                "─────────────────────────────\n" +
                "YOUR BOOKING DETAILS\n" +
                "─────────────────────────────\n" +
                "Name        : " + booking.getName() + "\n" +
                "Email       : " + booking.getEmail() + "\n" +
                "Phone       : " + booking.getPhone() + "\n\n" +
                "Confirmed Days:\n" + days + "\n\n" +
                "─────────────────────────────\n" +
                "Our team will reach out to you shortly via WhatsApp to discuss\n" +
                "further details about your event.\n\n" +
                "If you have any questions in the meantime, feel free to contact us:\n" +
                "📞 +91 9288188939\n" +
                "📧 sofidigitalstudio@gmail.com\n" +
                "📸 instagram.com/sofidigitalstudio\n\n" +
                "Thank you for choosing Sofi Digital Studio.\n" +
                "We look forward to capturing your special moments!\n\n" +
                "Warm regards,\n" +
                "Sofi Digital Studio™";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(booking.getEmail());
        message.setSubject("✅ Booking Confirmed — Sofi Digital Studio");
        message.setText(body);
        mailSender.send(message);
    }

    @Override
    public void sendBookingCancellationToClient(Booking booking) {
        String body = "Dear " + booking.getName() + ",\n\n" +
                "We regret to inform you that your booking with Sofi Digital Studio\n" +
                "has been cancelled.\n\n" +
                "─────────────────────────────\n" +
                "CANCELLED BOOKING DETAILS\n" +
                "─────────────────────────────\n" +
                "Name        : " + booking.getName() + "\n" +
                "Email       : " + booking.getEmail() + "\n" +
                "Phone       : " + booking.getPhone() + "\n\n" +
                "─────────────────────────────\n" +
                "We sincerely apologize for any inconvenience this may have caused.\n\n" +
                "If you would like to reschedule or need more information,\n" +
                "please don't hesitate to reach out to us:\n" +
                "📞 +91 9288188939\n" +
                "📧 sofidigitalstudio@gmail.com\n" +
                "📸 instagram.com/sofidigitalstudio\n\n" +
                "We hope to have the opportunity to work with you in the future.\n\n" +
                "Warm regards,\n" +
                "Sofi Digital Studio™";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(booking.getEmail());
        message.setSubject("❌ Booking Cancelled — Sofi Digital Studio");
        message.setText(body);
        mailSender.send(message);
    }
}
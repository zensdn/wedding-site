package com.sofi.SofiStudio;

import com.sofi.SofiStudio.model.User;
import com.sofi.SofiStudio.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    @Value("${app.admin-panel-username}")
    private String username;

    @Value("${app.admin-panel-password}")
    private String password;

    @Override
    public void run(String... args) {
        if (userRepo.findByUsername(username).isEmpty()) {
            User admin = new User();
            admin.setUsername(username);
            admin.setPassword(passwordEncoder.encode(password));
            admin.setRole("ADMIN");
            userRepo.save(admin);
            System.out.println("Admin User Created!");
        }
    }

}

package com.sofi.SofiStudio.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class BookingDto {

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Please Provide a valid email")
    private String email;

    @NotBlank(message = "Name is required")
    private String phone;

    private String description;

    @NotEmpty(message = "Please Select at Least One Day")
    private List<LocalDate> days;


}

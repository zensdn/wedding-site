package com.sofi.SofiStudio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String home() { return "forward:/index.html"; }

    @GetMapping("/gallery")
    public String gallery() { return "forward:/gallery.html"; }

    @GetMapping("/booking")
    public String booking() { return "forward:/booking.html"; }

    @GetMapping("/admin")
    public String admin() { return "forward:/admin.html"; }
}
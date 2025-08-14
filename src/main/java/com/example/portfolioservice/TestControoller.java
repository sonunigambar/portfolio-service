package com.example.portfolioservice;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/portfolio")
public class TestControoller {
    @GetMapping("/admin/data/")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminData() {
        return "Admin-only portfolio data";
    }

    @GetMapping("/user/data/")
    @PreAuthorize("hasRole('USER')")
    public String userData() {
        return "User-only portfolio data";
    }
}

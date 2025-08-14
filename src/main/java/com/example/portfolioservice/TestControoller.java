package com.example.portfolioservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/portfolio")
public class TestControoller {
    private static final Logger log = LoggerFactory.getLogger(TestControoller.class);

    @GetMapping("/admin/data/")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminData() {
        return "Admin-only portfolio data";
    }

    @GetMapping("/user/data/")
    @PreAuthorize("hasRole('USER')")
    public String userData() {
        log.info("User-only portfolio data");
        return "User-only portfolio data";
    }
}

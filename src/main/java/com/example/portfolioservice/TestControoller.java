package com.example.portfolioservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/portfolio")
public class TestControoller {

    @Autowired
    UserRepo userRepo;
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
    @GetMapping("/test/")
    public String test() {
        log.info("User-only portfolio data");
        return "Test From portfolio data";

    }
    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable String id) {
        log.info("Fetching UserInfo");
        return userRepo.findByUserId(Integer.parseInt(id));

    }

    @PostMapping("/createUser")
    public User getUser(@RequestBody User user) {
        log.info("Fetching UserInfo");
        return userRepo.save(user);

    }
}

package com.snovasys.ledgerline.controller;

import com.snovasys.ledgerline.model.User;
import com.snovasys.ledgerline.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginRequest) {
        Optional<User> userOpt = userRepository.findByUsername(loginRequest.getUsername());
        
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(401).body("Invalid username or password");
    }
}
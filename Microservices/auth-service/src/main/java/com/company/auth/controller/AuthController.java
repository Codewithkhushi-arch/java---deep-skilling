package com.company.auth.controller;

import com.company.auth.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestParam String username, @RequestParam String password) {
        // Simple static authentication check for exercise purposes
        if ("admin".equals(username) && "password".equals(password)) {
            String token = jwtTokenProvider.createToken(username);
            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @GetMapping("/validate")
    public ResponseEntity<Map<String, Object>> validateToken(@RequestParam String token) {
        boolean isValid = jwtTokenProvider.validateToken(token);
        Map<String, Object> response = new HashMap<>();
        response.put("valid", isValid);
        if (isValid) {
            response.put("username", jwtTokenProvider.getUsername(token));
        }
        return ResponseEntity.ok(response);
    }
}

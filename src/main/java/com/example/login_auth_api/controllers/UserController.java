package com.example.login_auth_api.controllers;

import com.example.login_auth_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<String> getUser() {
        return ResponseEntity.ok("Sucesso!");
    }

    @GetMapping("/uuid/{email}")
    public ResponseEntity<?> getUserUuidByEmail(@PathVariable String email) {
        return userRepository.findByEmail(email)
                .map(user -> ResponseEntity.ok().body("UUID do usuário: " + user.getId()))
                .orElse(ResponseEntity.notFound().build());
    }
}

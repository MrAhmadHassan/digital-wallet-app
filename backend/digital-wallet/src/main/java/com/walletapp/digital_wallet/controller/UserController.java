package com.walletapp.digital_wallet.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user/profile")
    public ResponseEntity<?> getProfile(Authentication authentication) {
        // authentication is automatically injected
        return ResponseEntity.ok(authentication.getName());
    }

}

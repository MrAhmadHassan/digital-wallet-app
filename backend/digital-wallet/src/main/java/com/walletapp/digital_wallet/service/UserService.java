package com.walletapp.digital_wallet.service;


import com.walletapp.digital_wallet.dto.AuthResponse;
import com.walletapp.digital_wallet.dto.LoginRequest;
import com.walletapp.digital_wallet.dto.RegisterRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {
    AuthResponse register(RegisterRequest request);
    AuthResponse login(LoginRequest request);

    UserDetails loadUserByEmail(String email)
            throws UsernameNotFoundException;

    UserDetails loadUserByUsername(String userName);
}

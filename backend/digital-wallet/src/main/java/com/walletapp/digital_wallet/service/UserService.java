package com.walletapp.digital_wallet.service;


import com.walletapp.digital_wallet.dto.AuthResponse;
import com.walletapp.digital_wallet.dto.LoginRequest;
import com.walletapp.digital_wallet.dto.RegisterRequest;

public interface UserService {
    AuthResponse register(RegisterRequest request);
    AuthResponse login(LoginRequest request);
}

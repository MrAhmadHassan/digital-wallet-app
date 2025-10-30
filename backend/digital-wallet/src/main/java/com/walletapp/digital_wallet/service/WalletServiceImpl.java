package com.walletapp.digital_wallet.service;

import com.walletapp.digital_wallet.entity.User;
import com.walletapp.digital_wallet.entity.Wallet;
import com.walletapp.digital_wallet.repository.UserRepository;
import com.walletapp.digital_wallet.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;
    private final UserRepository userRepository;

    @Override
    public Wallet createWalletForUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Wallet wallet = Wallet.builder()
                .balance(BigDecimal.valueOf(0.0))
                .user(user)
                .build();

        return walletRepository.save(wallet);
    }

    @Override
    public Wallet getWalletByUserId(Long userId) {
        return walletRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Wallet not found"));
    }

    @Override
    @Transactional
    public Wallet updateBalance(Long userId, Double amount) {
        Wallet wallet = getWalletByUserId(userId);
        wallet.setBalance(wallet.getBalance().add(BigDecimal.valueOf(amount)));
        return walletRepository.save(wallet);
    }
}

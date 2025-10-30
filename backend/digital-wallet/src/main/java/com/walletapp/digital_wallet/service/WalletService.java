package com.walletapp.digital_wallet.service;

import com.walletapp.digital_wallet.entity.Wallet;

public interface WalletService {
    Wallet createWalletForUser(Long userId);
    Wallet getWalletByUserId(Long userId);
    Wallet updateBalance(Long userId, Double amount);
}

package com.walletapp.digital_wallet.controller;

import com.walletapp.digital_wallet.entity.Wallet;
import com.walletapp.digital_wallet.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wallet")
@RequiredArgsConstructor
public class WalletController {

    private final WalletService walletService;

    // ✅ Get wallet for logged-in user
    @GetMapping
    public Wallet getWallet(Authentication authentication) {
        Long userId = getUserIdFromAuth(authentication);
        return walletService.getWalletByUserId(userId);
    }

    // ✅ Add amount to wallet (for now)
    @PutMapping("/add")
    public Wallet addAmount(Authentication authentication, @RequestParam double amount) {
        Long userId = getUserIdFromAuth(authentication);
        return walletService.updateBalance(userId, amount);
    }

    // ✅ Deduct amount (optional — future transaction module)
    @PutMapping("/deduct")
    public Wallet deductAmount(Authentication authentication, @RequestParam double amount) {
        Long userId = getUserIdFromAuth(authentication);
        return walletService.updateBalance(userId, -amount);
    }

    // 🔒 Helper method to get userId from authentication
    private Long getUserIdFromAuth(Authentication authentication) {
        var user = (com.walletapp.digital_wallet.entity.User) authentication.getPrincipal();
        return user.getId();
    }
}

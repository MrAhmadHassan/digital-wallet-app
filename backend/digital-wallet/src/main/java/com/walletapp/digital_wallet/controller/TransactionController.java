package com.walletapp.digital_wallet.controller;

import com.walletapp.digital_wallet.entity.Transaction;
import com.walletapp.digital_wallet.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/transfer")
    public Transaction transfer(
            @RequestParam Long senderId,
            @RequestParam Long receiverId,
            @RequestParam BigDecimal amount
    ) {
        return transactionService.transfer(senderId, receiverId, amount);
    }
}

package com.walletapp.digital_wallet.controller;

import com.walletapp.digital_wallet.entity.Transaction;
import com.walletapp.digital_wallet.service.TransactionHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionHistoryController {

    private final TransactionHistoryService transactionHistoryService;

    @GetMapping("/history/{walletId}")
    public List<Transaction> getHistory(@PathVariable Long walletId) {
        return transactionHistoryService.getTransactionHistory(walletId);
    }
}

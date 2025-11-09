package com.walletapp.digital_wallet.service;

import com.walletapp.digital_wallet.entity.Transaction;
import com.walletapp.digital_wallet.entity.Wallet;
import com.walletapp.digital_wallet.repository.TransactionRepository;
import com.walletapp.digital_wallet.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionHistoryService {

    private final TransactionRepository transactionRepository;
    private final WalletRepository walletRepository;

    public List<Transaction> getTransactionHistory(Long walletId) {
        Wallet wallet = walletRepository.findById(walletId)
                .orElseThrow(() -> new RuntimeException("Wallet not found"));

        List<Transaction> sent = transactionRepository.findBySenderWallet(wallet);
        List<Transaction> received = transactionRepository.findByReceiverWallet(wallet);

        List<Transaction> all = new ArrayList<>();
        all.addAll(sent);
        all.addAll(received);

        return all;
    }
}

package com.walletapp.digital_wallet.service;

import com.walletapp.digital_wallet.entity.*;
import com.walletapp.digital_wallet.enums.TransactionType;
import com.walletapp.digital_wallet.repository.TransactionRepository;
import com.walletapp.digital_wallet.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final WalletRepository walletRepository;
    private final TransactionRepository transactionRepository;

    @Transactional
    public Transaction transfer(Long senderId, Long receiverId, BigDecimal amount) {
        Wallet sender = walletRepository.findById(senderId)
                .orElseThrow(() -> new RuntimeException("Sender wallet not found"));
        Wallet receiver = walletRepository.findById(receiverId)
                .orElseThrow(() -> new RuntimeException("Receiver wallet not found"));

        if (sender.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Insufficient balance");
        }

        sender.setBalance(sender.getBalance().subtract(amount));
        receiver.setBalance(receiver.getBalance().add(amount));

        walletRepository.save(sender);
        walletRepository.save(receiver);

        Transaction transaction = Transaction.builder()
                .senderWallet(sender)
                .receiverWallet(receiver)
                .amount(amount)
                .timestamp(LocalDateTime.now())
                .type(TransactionType.TRANSFER)
                .status("SUCCESS")
                .build();

        return transactionRepository.save(transaction);
    }
}

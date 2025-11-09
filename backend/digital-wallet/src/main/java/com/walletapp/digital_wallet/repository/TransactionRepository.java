package com.walletapp.digital_wallet.repository;

import com.walletapp.digital_wallet.entity.Transaction;
import com.walletapp.digital_wallet.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // All transactions where wallet acted as sender
    List<Transaction> findBySenderWallet(Wallet wallet);

    // All transactions where wallet acted as receiver
    List<Transaction> findByReceiverWallet(Wallet wallet);

}

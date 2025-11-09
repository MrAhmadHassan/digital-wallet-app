package com.walletapp.digital_wallet.entity;

import com.walletapp.digital_wallet.enums.TransactionType;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_wallet_id")
    private Wallet senderWallet;

    @ManyToOne
    @JoinColumn(name = "receiver_wallet_id")
    private Wallet receiverWallet;

    private BigDecimal amount;
    private LocalDateTime timestamp;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    private String status; // e.g. SUCCESS, FAILED
}

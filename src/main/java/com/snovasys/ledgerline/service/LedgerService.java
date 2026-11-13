package com.snovasys.ledgerline.service;

import com.snovasys.ledgerline.model.Account;
import com.snovasys.ledgerline.model.Transaction;
import com.snovasys.ledgerline.repository.AccountRepository;
import com.snovasys.ledgerline.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class LedgerService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Transactional
    public Transaction transferFunds(Long sourceAccountId, Long targetAccountId, BigDecimal amount, String description) {
        // 1. Validate amount
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Transfer amount must be greater than zero.");
        }

        // 2. Fetch source and target accounts
        Account sourceAccount = accountRepository.findById(sourceAccountId)
                .orElseThrow(() -> new RuntimeException("Source account not found: " + sourceAccountId));

        Account targetAccount = accountRepository.findById(targetAccountId)
                .orElseThrow(() -> new RuntimeException("Target account not found: " + targetAccountId));

        // 3. Check sufficient balance
        if (sourceAccount.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Insufficient funds in source account.");
        }

        // 4. Perform double-entry balance updates
        sourceAccount.setBalance(sourceAccount.getBalance().subtract(amount));
        targetAccount.setBalance(targetAccount.getBalance().add(amount));

        accountRepository.save(sourceAccount);
        accountRepository.save(targetAccount);

        // 5. Record the transaction
        Transaction transaction = new Transaction();
        transaction.setSourceAccount(sourceAccount);
        transaction.setTargetAccount(targetAccount);
        transaction.setAmount(amount);
        transaction.setDescription(description);
        transaction.setTimestamp(LocalDateTime.now());

        return transactionRepository.save(transaction);
    }
}
package com.snovasys.ledgerline.controller;

import com.snovasys.ledgerline.dto.TransferRequest;
import com.snovasys.ledgerline.model.Transaction;
import com.snovasys.ledgerline.service.LedgerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ledger")
public class LedgerController {

    private final LedgerService ledgerService;

    public LedgerController(LedgerService ledgerService) {
        this.ledgerService = ledgerService;
    }

    @PostMapping("/transfer")
    public ResponseEntity<?> transfer(@RequestBody TransferRequest request) {
        try {
            Transaction transaction = ledgerService.transferFunds(
                    request.getSourceAccountId(),
                    request.getTargetAccountId(),
                    request.getAmount(),
                    request.getReference()
            );
            return ResponseEntity.ok(transaction);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
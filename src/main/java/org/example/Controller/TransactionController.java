package org.example.Controller;




import org.example.Service.TransactionService;
import org.example.dtos.request.AirtimeRequest;
import org.example.dtos.response.TransactionResponse;
import org.example.dtos.request.TransferRequest;
import java.util.List;
import java.util.Optional;

// Assuming ResponseEntity is from Spring, but keeping plain for now - we'll add annotations later
// For now, just the class structure

public class TransactionController {
    private TransactionService transactionService;

    // Constructor (for dependency injection later)
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    // Placeholder for @PostMapping("/transfer") - doTransfer method
    public Optional<TransactionResponse> doTransfer(TransferRequest request) {
        return transactionService.doTransfer(request);
    }

    // Placeholder for @PostMapping("/airtime") - buyAirtime method
    public Optional<TransactionResponse> buyAirtime(AirtimeRequest request) {
        return transactionService.buyAirtime(request);
    }

    // Placeholder for @GetMapping("/history/{accountNumber}") - getTransactionHistory method
    public Optional<List<TransactionResponse>> getTransactionHistory(String accountNumber) {
        return transactionService.getTransactionHistory(accountNumber);
    }
}
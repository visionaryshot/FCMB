package org.example.Controller;




import org.example.Service.TransactionService;
import org.example.dtos.request.AirtimeRequest;
import org.example.dtos.response.TransactionResponse;
import org.example.dtos.request.TransferRequest;
import java.util.List;
import java.util.Optional;



public class TransactionController {
    private TransactionService transactionService;


    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }


    public Optional<TransactionResponse> doTransfer(TransferRequest request) {
        return transactionService.doTransfer(request);
    }


    public Optional<TransactionResponse> buyAirtime(AirtimeRequest request) {
        return transactionService.buyAirtime(request);
    }


    public Optional<List<TransactionResponse>> getTransactionHistory(String accountNumber) {
        return transactionService.getTransactionHistory(accountNumber);
    }
}
package org.example.Service;
import org.example.data.models.Account;
import org.example.data.models.Customer;
import org.example.data.models.Transaction;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.example.data.repository.AccountRepository;
import org.example.data.repository.TransactionRepository;
import org.example.dtos.request.AirtimeRequest;
import org.example.dtos.request.TransferRequest;
import org.example.dtos.response.TransactionResponse;

public class TransactionService {
    private AccountRepository accountRepository;
    private TransactionRepository transactionRepository;
    private DiscountService discountService;

    // Constructor (for dependency injection later)
    public TransactionService(AccountRepository accountRepository, TransactionRepository transactionRepository, DiscountService discountService) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
        this.discountService = discountService;
    }

    public Optional<TransactionResponse> doTransfer(TransferRequest request) {
        Optional<Account> sourceAccountOpt = accountRepository.findByAccountNumber(request.getSourceAccount());
        if (sourceAccountOpt.isEmpty()) {
            return Optional.empty();
        }

        Optional<Account> destinationAccountOpt = accountRepository.findByAccountNumber(request.getDestinationAccount());
        if (destinationAccountOpt.isEmpty()) {
            return Optional.empty();
        }

        Account sourceAccount = sourceAccountOpt.get();
        Account destinationAccount = destinationAccountOpt.get();
        Customer customer = sourceAccount.getCustomer();

        BigDecimal discountAmount = discountService.calculateDiscount(customer, request.getAmount(), "TRANSFER", LocalDateTime.now());

        Transaction transaction = new Transaction();
        transaction.setSourceAccount(sourceAccount);
        transaction.setDestinationAccount(destinationAccount);
        transaction.setAmount(request.getAmount());
        transaction.setDiscountAmount(discountAmount);
        transaction.setType("TRANSFER");
        transaction.setTransactionDate(LocalDateTime.now());

        Transaction savedTransaction = transactionRepository.save(transaction);

        return Optional.of(mapToResponse(savedTransaction));
    }

    public Optional<TransactionResponse> buyAirtime(AirtimeRequest request) {
        Optional<Account> sourceAccountOpt = accountRepository.findByAccountNumber(request.getSourceAccount());
        if (sourceAccountOpt.isEmpty()) {
            return Optional.empty();
        }

        Account sourceAccount = sourceAccountOpt.get();

        Transaction transaction = new Transaction();
        transaction.setSourceAccount(sourceAccount);
        transaction.setAmount(request.getAmount());
        transaction.setDiscountAmount(BigDecimal.ZERO);
        transaction.setType("AIRTIME");
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setNetworkProvider(request.getNetworkProvider());
        transaction.setPhoneNumber(request.getPhoneNumber());

        Transaction savedTransaction = transactionRepository.save(transaction);

        return Optional.of(mapToResponse(savedTransaction));
    }

    public Optional<List<TransactionResponse>> getTransactionHistory(String accountNumber) {
        List<Transaction> transactions = transactionRepository.findBySourceAccount_AccountNumberOrDestinationAccount_AccountNumber(accountNumber, accountNumber);

        if (transactions.isEmpty()) {
            return Optional.empty();
        }

        List<TransactionResponse> responses = new ArrayList<>();
        for (Transaction transaction : transactions) {
            responses.add(mapToResponse(transaction));
        }

        return Optional.of(responses);
    }

    private TransactionResponse mapToResponse(Transaction transaction) {
        TransactionResponse response = new TransactionResponse();
        response.setId(transaction.getId());
        response.setSourceAccount(transaction.getSourceAccount().getAccountNumber());
        if (transaction.getDestinationAccount() != null) {
            response.setDestinationAccount(transaction.getDestinationAccount());
        }
        response.setAmount(transaction.getAmount());
        response.setDiscountAmount(transaction.getDiscountAmount());
        response.setType(transaction.getType());
        response.setTransactionDate(transaction.getTransactionDate());
        response.setNetworkProvider(transaction.getNetworkProvider());
        response.setPhoneNumber(transaction.getPhoneNumber());
        return response;
    }
}
package org.example.data.repository;

import org.example.data.models.Customer;
import org.example.data.models.Transaction;

import java.util.List;

public interface TransactionRepository {
    Transaction save(Transaction transaction);
    List<Transaction> findBySourceAccount_AccountNumberOrDestinationAccount_AccountNumber(String sourceAccountNumber, String destAccountNumber);
    long countByCustomerAndMonth(Customer customer, int month, int year, String type);
}
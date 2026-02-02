package org.example.data.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    private Long id;
    private Account sourceAccount;
    private Account destinationAccount;
    private BigDecimal amount;
    private BigDecimal discountAmount;
    private String type; // TRANSFER or AIRTIME
    private LocalDateTime transactionDate;
    private String networkProvider;
    private String phoneNumber;

    public void setSourceAccount(Account sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public void setDestinationAccount(Account destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public void setType(String transfer) {
        this.type = transfer;
    }

    public void setTransactionDate(LocalDateTime now) {
        this.transactionDate = now;
    }

    public void setNetworkProvider(Object networkProvider) {
        this.networkProvider = (String) networkProvider;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public Object getSourceAccount() {
        return sourceAccount;
    }

    public String getDestinationAccount() {
        return destinationAccount != null;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getNetworkProvider() {
        return networkProvider;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public String getType() {
        return type;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
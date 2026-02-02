package org.example.dtos.request;

import java.math.BigDecimal;

public class AirtimeRequest {
    private String sourceAccount;

    public void setSourceAccount(String sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public void setNetworkProvider(String networkProvider) {
        this.networkProvider = networkProvider;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private String networkProvider;
    private BigDecimal amount;
    private String phoneNumber;

    public String getSourceAccount() {
        return sourceAccount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Object getNetworkProvider() {
        return networkProvider;
    }
}
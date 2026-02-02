package org.example.data.models;

public class Account {
    private Long id;
    private String accountNumber;
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }
}

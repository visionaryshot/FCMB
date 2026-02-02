package org.example.data.models;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

public class Customer {
    private Long id;
    private String name;
    private String type;
    private LocalDate registrationDate;
    private List<Account> accounts;

    public Instant getRegistrationDate() {
        return registrationDate.atStartOfDay().toInstant(java.time.ZoneOffset.UTC);
    }

    public String getType() {
        return type;
    }
}
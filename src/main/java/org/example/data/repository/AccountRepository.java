package org.example.data.repository;
import org.example.data.models.Account;
import java.util.Optional;
public interface AccountRepository {
    Optional<Account> findByAccountNumber(String accountNumber);
    Account save(Account account);
}
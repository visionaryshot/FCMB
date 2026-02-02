package org.example.data.repository;
import org.example.data.models.Customer;
import java.util.Optional;

public interface CustomerRepository {
    Optional<Customer> findById(Long id);
    Customer save(Customer customer);
}
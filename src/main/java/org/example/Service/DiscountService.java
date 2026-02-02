package org.example.Service;
import org.example.data.models.Customer;
import org.example.data.repository.TransactionRepository;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DiscountService {
    private TransactionRepository transactionRepository;

    public DiscountService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public BigDecimal calculateDiscount(Customer customer, BigDecimal amount, String transactionType,
                                        LocalDateTime transactionDate) {
        if (!"TRANSFER".equals(transactionType)) {
            return BigDecimal.ZERO;
        }

        BigDecimal discountPercent = BigDecimal.ZERO;
        LocalDate now = transactionDate.toLocalDate();
        int month = now.getMonthValue();
        int year = now.getYear();

        long transactionCount = transactionRepository.countByCustomerAndMonth(
                customer, month, year, "TRANSFER");


        boolean isOver4Years = customer.getRegistrationDate().isBefore(Instant.from(now.minusYears(4)));
        if (isOver4Years && transactionCount < 3) {
            discountPercent = discountPercent.add(BigDecimal.valueOf(10));
        }

        if (transactionCount >= 3) {
            if ("BUSINESS".equals(customer.getType()) && amount.compareTo(BigDecimal.valueOf(150000)) > 0) {
                discountPercent = discountPercent.add(BigDecimal.valueOf(27));
            } else if ("RETAIL".equals(customer.getType()) && amount.compareTo(BigDecimal.valueOf(50000)) > 0) {
                discountPercent = discountPercent.add(BigDecimal.valueOf(18));
            }
        }

        return amount.multiply(discountPercent).divide(BigDecimal.valueOf(100));
    }
}

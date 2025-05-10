package com.moneylender.backend.repository;

import com.moneylender.backend.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByPersonIdOrderByDate(Long personId);
}

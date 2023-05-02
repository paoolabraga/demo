package com.example.demo.repositories;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Payment;

@Transactional
public interface PaymentRepository extends JpaRepository<Payment, Long> {

	Optional<Payment> findById(Long id);

	void deleteById(Long id);

	@SuppressWarnings("unchecked")
	Payment save(Payment payment);

	@Modifying
	@Query("update Payment p set p.status = ?1 where p.id = ?2")
	void setNewStatus(String status, Long id);

}

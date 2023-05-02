package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.PaymentDTO;
import com.example.demo.entities.Payment;
import com.example.demo.repositories.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository repository;

	@Autowired
	private PaymentRepository PaymentRepository;

	@Transactional(readOnly = true)
	public Page<Object> findAll(Pageable pagealbe) {
		PaymentRepository.findAll();
		Page<Payment> result = repository.findAll(pagealbe);

		return result.map(x -> new PaymentDTO(x));
	}

	public void deletePayment(Long id) {
		Optional<Payment> p = repository.findById(id);
		if (p.get().getStatus() == "PENDENTE_DE_PROCESSAMENTO") {
			repository.deleteById(id);
		}

	}

	public Optional<Payment> updatePayment(Payment payment) {
		Optional<Payment> p = repository.findById(payment.getId());

		if (p.get().getStatus() == "PENDENTE_DE_PROCESSAMENTO") {
			repository.setNewStatus(payment.getStatus(), payment.getId());
		}

		if (p.get().getStatus() == "PROCESSADO_COM_FALHA") {
			if (payment.getStatus() == "PENDENTE_DE_PROCESSAMENTO") {
				repository.setNewStatus(payment.getStatus(), payment.getId());
			}

		}

		return repository.findById(payment.getId());
	}

	public Payment addPayment(Payment payment) {
		payment.setStatus("PENDENTE_DE_PROCESSAMENTO");

		if (payment.getMetodoPagamento().getId() != 3 && payment.getMetodoPagamento().getId() != 4) {
			payment.setNumeroCartao(null);
		}

		return repository.save(payment);
	}

	public Optional<Payment> findById(Long id) {
		return repository.findById(id);
	}

}

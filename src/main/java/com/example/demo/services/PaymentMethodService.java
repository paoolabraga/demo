package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.PaymentMethodDTO;
import com.example.demo.entities.PaymentMethod;
import com.example.demo.repositories.PaymentMethodRepository;

@Service
public class PaymentMethodService {
	
	@Autowired
	private PaymentMethodRepository repository;

	@Autowired
	private PaymentMethodRepository PaymentMethodRepository;

	@Transactional(readOnly = true)
	public Page<Object> findAll(Pageable pagealbe) {
		PaymentMethodRepository.findAll();
		Page<PaymentMethod> result = repository.findAll(pagealbe);

		return result.map(x -> new PaymentMethodDTO(x));
	}

	public void deletePaymentMethod(Long id) {
		repository.deleteById(id);

	}

	public PaymentMethod updatePaymentMethod(PaymentMethod paymentMethod) {
		return repository.save(paymentMethod);
	}

	public PaymentMethod addPayment(PaymentMethod paymentMethod) {

		return repository.save(paymentMethod);
	}

}

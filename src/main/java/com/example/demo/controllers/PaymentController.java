package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Payment;
import com.example.demo.services.PaymentService;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {

	@Autowired
	private PaymentService service;

	@GetMapping
	public ResponseEntity<Page<Object>> findAll(Pageable pageable) {
		Page<Object> list = service.findAll(pageable);
		return ResponseEntity.ok(list);
	}

	@PostMapping(value = "/add")
	public ResponseEntity<Payment> addPayment(@RequestBody Payment payment) {
		Payment newPayment = service.addPayment(payment);
		return new ResponseEntity<Payment>(newPayment, HttpStatus.OK);

	}

	@PutMapping(value = "/update")
	public ResponseEntity<Optional<Payment>> updatePayment(@RequestBody Payment payment) {
		Optional<Payment> updateThePayment = service.updatePayment(payment);

		return ResponseEntity.ok(updateThePayment);

	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> deletePayment(@PathVariable("id") Long id) {
		service.deletePayment(id);
		return ResponseEntity.ok(null);
	}

}

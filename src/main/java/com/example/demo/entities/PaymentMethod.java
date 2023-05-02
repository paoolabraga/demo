package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_metodo")
public class PaymentMethod {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String metodo;

	@OneToMany(mappedBy = "metodoPagamento")
	private List<Payment> payment = new ArrayList<>();

	public PaymentMethod() {
	}

	public PaymentMethod(Long id, String metodo) {
		super();
		this.id = id;
		this.metodo = metodo;
	}

	public PaymentMethod(PaymentMethod paymentMethod) {
		super();
		this.id = paymentMethod.getId();
		this.metodo = paymentMethod.getMetodo();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

}

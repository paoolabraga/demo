package com.example.demo.dto;

import java.io.Serializable;

import com.example.demo.entities.PaymentMethod;

public class PaymentMethodDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String metodo;

	public PaymentMethodDTO() {
	}

	public PaymentMethodDTO(Long id, String metodo) {
		super();
		this.id = id;
		this.metodo = metodo;
	}

	public PaymentMethodDTO(PaymentMethod entity) {
		super();
		this.id = entity.getId();
		this.metodo = entity.getMetodo();
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

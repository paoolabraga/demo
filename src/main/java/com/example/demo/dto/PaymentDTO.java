package com.example.demo.dto;

import java.io.Serializable;

import com.example.demo.entities.Payment;

public class PaymentDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private int codigoDebito;
	private String cpfCnpj;

	private PaymentMethodDTO metodoPagamento;

	private String numeroCartao;
	private double valorPagamento;

	private String status;

	public PaymentDTO() {
	}

	public PaymentDTO(Long id, int codigoDebito, String cpfCnpj, PaymentMethodDTO metodoPagamento, String numeroCartao,
			double valorPagamento, String status) {
		super();
		this.id = id;
		this.codigoDebito = codigoDebito;
		this.cpfCnpj = cpfCnpj;
		this.metodoPagamento = metodoPagamento;
		this.numeroCartao = numeroCartao;
		this.valorPagamento = valorPagamento;
	}
	
	public PaymentDTO(Long id, String status) {
		super();
		this.id = id;
		this.status = status;
	}

	public PaymentDTO(Payment entity) {
		super();
		this.id = entity.getId();
		this.codigoDebito = entity.getCodigoDebito();
		this.cpfCnpj = entity.getCpfCnpj();
		this.metodoPagamento = new PaymentMethodDTO(entity.getMetodoPagamento());
		this.numeroCartao = entity.getNumeroCartao();
		this.valorPagamento = entity.getValorPagamento();
		this.status = entity.getStatus();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCodigoDebito() {
		return codigoDebito;
	}

	public void setCodigoDebito(int codigoDebito) {
		this.codigoDebito = codigoDebito;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public double getValorPagamento() {
		return valorPagamento;
	}

	public void setValorPagamento(double valorPagamento) {
		this.valorPagamento = valorPagamento;
	}

	public PaymentMethodDTO getMetodoPagamento() {
		return metodoPagamento;
	}

	public void setMetodoPagamento(PaymentMethodDTO metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

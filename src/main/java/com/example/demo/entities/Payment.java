package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name = "tb_payment")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int codigoDebito;
	private String cpfCnpj;

	@ManyToOne
	@JoinColumn(name = "metodo_id")
	private PaymentMethod metodoPagamento;

	private String numeroCartao;
	private double valorPagamento;

	@Value("AGUARDANDO_PROCESSAMENTO")
	private String status;

	public Payment() {
	}

	public Payment(Long id, int codigoDebito, String cpfCnpj, PaymentMethod metodoPagamento, String numeroCartao,
			double valorPagamento, String status) {
		super();
		this.id = id;
		this.codigoDebito = codigoDebito;
		this.cpfCnpj = cpfCnpj;
		this.metodoPagamento = metodoPagamento;
		this.numeroCartao = numeroCartao;
		this.valorPagamento = valorPagamento;
		this.status = status;
	}
	
	public Payment(Long id, String status) {
		super();
		this.id = id;
		this.status = status;
	}

	public Payment(Payment payment) {
		super();
		this.id = payment.getId();
		this.codigoDebito = payment.getCodigoDebito();
		this.cpfCnpj = payment.getCpfCnpj();
		this.metodoPagamento = new PaymentMethod(payment.getMetodoPagamento());
		this.numeroCartao = payment.getNumeroCartao();
		this.valorPagamento = payment.getValorPagamento();
		this.status = payment.getStatus();
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

	public PaymentMethod getMetodoPagamento() {
		return metodoPagamento;
	}

	public void setMetodoPagamento(PaymentMethod metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

package entities;

import java.time.LocalDate;

public class CartaoDeCredito {
	
	private Long numero;
	private Integer cvv;
	private LocalDate vencimento;
	private String titular;
	private Integer senha;

	public CartaoDeCredito(Long numero, Integer cvv, LocalDate vencimento, String titular, Integer senha) {
		super();
		this.numero = numero;
		this.cvv = cvv;
		this.vencimento = vencimento;
		this.titular = titular;
		this.senha = senha;
	}

	public Long getNumero() {
		return numero;
	}

	public int getCvv() {
		return cvv;
	}

	public LocalDate getVencimento() {
		return vencimento;
	}

	public String getTitular() {
		return titular;
	}
	
	public void pagar(Integer senha) {
		if(this.senha == senha) {
			System.out.println("Transação aceita.");
		}
		else {
			System.out.print("Transação recusada.");
		}
	}
}

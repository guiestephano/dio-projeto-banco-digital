package entities;

import java.time.LocalDate;

public class CartaoDeCredito {
	
	private Long numero;
	private int cvv;
	private LocalDate vencimento;
	private String titular;
	private String senha;
	
	public CartaoDeCredito(Long numero, int cvv, LocalDate vencimento, String titular, String senha) {
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
	
	public void pagar(String senha) {
		if(this.senha == senha) {
			System.out.println("Transação aceita.");
		}
		else {
			System.out.print("Transação recusada.");
		}
	}
}

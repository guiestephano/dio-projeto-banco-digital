package entities;

import java.time.LocalDate;
import java.util.Random;

public final class ContaCorrente extends Conta{
	
	Random aleatorio = new Random();
	
	public ContaCorrente(Integer agencia, Integer numero, Double saldo, Cliente cliente) {
		super(agencia, numero, saldo, cliente);
	}
	
	public void solicitarCartao() {
		if(analizarPedidoCartao()) {
			System.out.println("Solicitação aceita.");
			Long numeroCartao = gerarNumeroCartao();
			Integer cvv = gerarCvv();
			LocalDate vencimento = gerarVencimento();
			Integer senha = gerarSenha();
			CartaoDeCredito cartao = new CartaoDeCredito(numeroCartao,cvv,vencimento,cliente.getNome(),senha);
			cliente.setCartao(cartao);
		}
		else {
			System.out.println("Solicitação recusada.");
		}
	}
	
	private boolean analizarPedidoCartao() {
		boolean aprovacao = aleatorio.nextBoolean();
		return aprovacao;
	}
	
	private Long gerarNumeroCartao() {
		String numero = "";
		for(int i = 0; i < 13; i++) {
			numero += aleatorio.nextInt(9);
		}
		return Long.parseLong(numero);
	}
	
	private Integer gerarCvv() {
		String numero = "";
		for(int i = 0; i < 3; i++) {
			numero += aleatorio.nextInt(9);
		}
		return Integer.parseInt(numero);
	}
	
	private LocalDate gerarVencimento() {
		LocalDate vencimento = LocalDate.now();
		vencimento.plusYears(5);
		return vencimento;
	}
	
	private Integer gerarSenha() {
		String numero = "";
		for(int i = 0; i < 4; i++) {
			numero += aleatorio.nextInt(9);
		}
		return Integer.parseInt(numero);
	}
}

package entities;

public class Cliente {
	
	private String nome;
	private Long cpf;
	private CartaoDeCredito cartao;
	
	public Cliente(String nome, Long cpf) {
		this.nome = nome;
		setCpf(cpf);
	}
	
	public String getNome() {
		return nome;
	}
	
	public Long getCpf() {
		return cpf;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCartao(CartaoDeCredito cartao) {
		this.cartao = cartao;
	}
	
	private void setCpf(Long cpf) {
		if(cpf.toString().length() == 11) {
			this.cpf = cpf;
		}
		else {
			throw new RuntimeException("Número de CPF inválido, o CPF deve conter 11 dígitos");
		}
	}
	
	@Override
	public String toString() {
		if(cartao == null) {
			return "nome: " + nome + " CPF: " + cpf;
		}
		return "nome: " + nome + " CPF: " + cpf + "Nº cartao: " + cartao.getNumero();
	}
}

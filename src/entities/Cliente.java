package entities;

public class Cliente {
	
	private String nome;
	private Long cpf;
	
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
		return "nome: " + nome + " CPF: " + cpf;
	}
}

package entities;

public abstract class Conta {
	
	protected Integer agencia;
	protected Integer numero;
	protected Double saldo;
	protected Cliente cliente;
	
	public Conta(Integer agencia,Integer numero,Double saldo,Cliente cliente){
		this.agencia = agencia;
		this.numero = numero;
		this.saldo = saldo;
		this.cliente = cliente;
	}
	
	public Integer getAgencia() {
		return agencia;
	}
	
	public Integer getNumero() {
		return numero;
	}
	
	public Double getSaldo() {
		return saldo;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void depositar(Double valor) {
		saldo += valor;
	}
	
	public void sacar(Double valor) {
		verificaSaldo(valor);
		saldo -= valor;
	}
	
	public void tranferir(Conta contaDestino, Double valor) {
		verificaSaldo(valor);
		saldo -= valor;
		contaDestino.depositar(valor);
	}
	
	protected void verificaSaldo(Double valor) {
		if(valor > saldo) {
			throw new RuntimeException("Valor de saque ultrapassa o saldo atual.");
		}
		
	}
	
}

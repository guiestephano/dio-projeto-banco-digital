package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class ContaPoupanca extends Conta{
	
	private Integer diaDeRendimento;
	private static double porcentagemDeRendimento = 0.5;
	
	public ContaPoupanca(Integer agencia,Integer numero,Double saldo,Cliente cliente, Integer diaDeRendimento) {
		super(agencia, numero, saldo, cliente);
		this.diaDeRendimento = diaDeRendimento;
	}
	
	public Integer getDiaDeRendimento() {
		return diaDeRendimento;
	}
	
	public static double getPorcentagemDeRendimento() {
		return porcentagemDeRendimento;
	}
	
	public void atualizarSaldo() {
		LocalDate hoje = LocalDate.now();
		if(hoje.getDayOfMonth() == diaDeRendimento) {
			saldo += calcularRenda(saldo);
		}
	}
	
	public void previewRendaProximosMeses() {
		
		double saldoFuturo = saldo;
		LocalDate dataFutura = LocalDate.of(LocalDate.now().getYear(),LocalDate.now().getMonth(),diaDeRendimento);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
		System.out.println("\nEsta é a previsão so seu saldo nos próximos 5 meses:");
		
		for(int i = 1; i <= 5; i++) {
			
			dataFutura = dataFutura.plusMonths(1);
			saldoFuturo += calcularRenda(saldoFuturo);
			
			System.out.println(i + "º: " + dataFutura.format(formatter) + " Saldo = " + String.format("%.2f", saldoFuturo));
		}
	}
	
	private Double calcularRenda(Double saldo) {
		return saldo * porcentagemDeRendimento / 100;
	}
}

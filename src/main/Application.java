package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entities.Cliente;
import entities.Conta;
import entities.ContaCorrente;
import entities.ContaPoupanca;

public class Application {
	public static void main(String[] args) {
		
		try {
			Random aleatorio = new Random();
			Cliente cliente01 = new Cliente("Tom Green", 12345678910L);
			Cliente cliente02 = new Cliente("Jhon Purple", 10987654321L);
			Cliente cliente03 = new Cliente("Ryan Red", 89017345621L);
			
			Conta contaPoupanca = new ContaPoupanca(111,222222, 1000.00, cliente01, 15);
			Conta contaCorrente01 = new ContaCorrente(222,111111,2500.00,cliente02);
			Conta contaCorrente02 = new ContaCorrente(333,444444,8750.00,cliente03);
			
			List<Conta> lista = new ArrayList<>();
			lista.add(contaCorrente02);
			lista.add(contaCorrente01);
			lista.add(contaPoupanca);
			
			System.out.println("------Status dos clientes------");
			mostrarStatusDosCliente(lista);
			
			System.out.println("\n------Operações de saque------");
			for(Conta conta : lista) {
				Double valor = aleatorio.nextDouble(10.0, 551.0);
				System.out.println("O cliente: \n" + conta.getCliente() + "\nSacou: R$ " + String.format("%.2f%n", valor));
				conta.sacar(valor);
			}
			
			System.out.println("\n------Operações de deposito------");
			for(Conta conta : lista) {
				Double valor = aleatorio.nextDouble(20.50, 210.00);
				System.out.println("O cliente: \n" + conta.getCliente() + "\nDepositou: R$ " + String.format("%.2f%n", valor));
				conta.depositar(valor);
			}

			System.out.println("\n------Operações de Tranferencia------");
			for(Conta conta : lista) {
				Conta contaDestino = lista.get(aleatorio.nextInt(3));
				Double valor = aleatorio.nextDouble(100.0, 300.0);
				System.out.println("O cliente: \n" + conta.getCliente() + "\nTranferiu: R$ " + String.format("%.2f", valor) + " Para:\n" + contaDestino.getCliente() + "\n");
				conta.tranferir(contaDestino, valor);
			}
			
			System.out.println("------Status dos clientes------");
			mostrarStatusDosCliente(lista);
			
			System.out.println("\n------Operações de Conta Poupança------");
			for(Conta conta : lista) {
				if(conta instanceof ContaPoupanca) {
					System.out.println("O cliente: \n" + conta.getCliente() + "\nVerificou a previsão da renda");
					((ContaPoupanca) conta).previewRendaProximosMeses();
				}
			}
			
			System.out.println("\n------Operações de Conta Corrente------");
			for(Conta conta : lista) {
				if(conta instanceof ContaCorrente) {
					System.out.println("\nO cliente: \n" + conta.getCliente() + "\nSolicitou cartão de crédito");
					((ContaCorrente) conta).solicitarCartao();
				}
			}
			
			System.out.println("\n------Status dos clientes------");
			mostrarStatusDosCliente(lista);
			
			
		
		}
		catch(RuntimeException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public static void mostrarStatusDosCliente(List<Conta> lista) {
		for(Conta conta : lista) {
			System.out.println(conta.getCliente() + "\nSaldo: " + String.format("%.2f%n", conta.getSaldo()));
		}
	}
}

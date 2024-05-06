package main;

import entities.Cliente;
import entities.ContaPoupanca;

public class Application {
	public static void main(String[] args) {
		
		try {
			Cliente cliente01 = new Cliente("Tom Green", 12345678910L);
			Cliente cliente02 = new Cliente("Jhon Purple", 10987654321L);
			
			ContaPoupanca contaPoupanca = new ContaPoupanca(111,222222, 1000.00, cliente01, 15);
			
			System.out.println(cliente01);
			System.out.println(cliente02);
			
			contaPoupanca.previewRendaProximosMeses();
		}
		catch(RuntimeException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}

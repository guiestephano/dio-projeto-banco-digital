package main;

import entities.Cliente;

public class Application {
	public static void main(String[] args) {
		
		try {
			Cliente cliente01 = new Cliente("Tom Green", 12345678910L);
			Cliente cliente02 = new Cliente("Jhon Purple", 10987654321L);
			
			System.out.println(cliente01);
			System.out.println(cliente02);
		}
		catch(RuntimeException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}

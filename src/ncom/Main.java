package ncom;

import java.util.Scanner;

public class Main {

	private static Scanner scanner;
	
	public static void main(String[] args) {
	
		System.out.println("Ingresar numero complejo");
		scanner = new Scanner(System.in);
		String numero = scanner.nextLine();
		Parser parser = new Parser();
		Complejo complejo = parser.parsear(numero);
		complejo.aBinario().print();
		complejo.aPolar().print();
		

	}

}

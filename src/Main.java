import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	
		System.out.println("Ingresar numero complejo");
		Scanner scanner = new Scanner(System.in);
		String numero = scanner.nextLine();
		Parser parser = new Parser();
		Complejo complejo = parser.parsear(numero);
		complejo.aBinario().print();
		complejo.aPolar().print();
		

	}

}


public class Binario implements Complejo{

	//Parte real de un numero complejo binario
	double real=0;
	//Parte imaginaria de un numero complejo binario
	double imaginaria=0;
	
	//Constructor de un numero complejo binario. Recibe 2 numeros, su parte real, y su parte imaginaria
	public Binario(double real, double imaginaria) {
		this.real = real;
		this.imaginaria = imaginaria;
	}
	
	public void print() {
		System.out.println("El numero binario es: "+ real + "+" + imaginaria + "j");
	}
	
	//Se devuelve a sí mismo.
	public Binario aBinario() {
		return this;
	}


	//Pasaje de un numero complejo binario a su forma polar
	public Polar aPolar() {
		
		//Modulo de un numero complejo sqrt(a^2+b^2)
		double modulo = Math.sqrt(Math.pow(real,2)+Math.pow(imaginaria,2));
		
		//Argumento de un numero complejo arctg(b/a)
		double argumento = Math.atan(imaginaria/real);
		
		//Se corrige el argumento dependiendo del cuadrante y se corrige al primer giro positivo
		//en caso de que sea mayor a 2pi o menor a 0
		argumento = corregirArgumento(argumento);
		
		//Crea y devuelve el número en polar.
		return new Polar(modulo, argumento);
	}
	
	private double corregirArgumento(double argumento) {
		
		//Dependiendo del cuadrante se corrige el argumento
		switch (cuadrante()) {
		
		case 2:
			//2do cuadrante
			argumento = argumento + Math.PI;
		case 3:
			//3er cuadrante
			argumento = argumento + Math.PI;
		case 4:
			//4to cuadrante
			argumento = argumento + 2*Math.PI;
		}
		
		//Si es menor a 0 suma 2pi hasta llegar al primer giro, si es mayor, resta.
		if(argumento < 0) {
			argumento = corregirArgumentoMenor(argumento);
		}else if(argumento > 2*Math.PI) {
			argumento = corregirArgumentoMayor(argumento);
		}
		return argumento;
	}
	
	//Obtiene el cuadrante del binario
	private int cuadrante() {
		if(real>=0 && imaginaria>=0) {
			return 1;
		}
		if(real<=0 && imaginaria>=0) {
			return 2;
		}
		if(real<=0 && imaginaria<=0) {
			return 3;
		}
		if(real>=0 && imaginaria<=0) {
			return 4;
		}
		return 0;
	}
	
	//Si es menor a 0, corrige cuadrante
	private double corregirArgumentoMenor(double argumento) {
		//Suma 2pi hasta que sea mayor a 0
		while(argumento < 0) {
			argumento = argumento + 2*Math.PI;
		}
		
		return argumento;
	}
	
	//Si es mayor a 2pi, corrige cuadrante
	private double corregirArgumentoMayor(double argumento) {
		//Resta 2pi hasta que sea menor que 2pi
		while(argumento > 2*Math.PI) {
			argumento = argumento - 2*Math.PI;
		}
		
		return argumento;
	}
	
}

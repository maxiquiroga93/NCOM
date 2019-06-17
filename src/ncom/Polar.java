package ncom;


import java.util.ArrayList;

public class Polar implements Complejo {
	
	double modulo=0;
	double argumento=0;
	boolean primitiva = false;
	
	

	public Polar(final double modulo, final double argumento) {
		this.modulo = modulo;
		this.argumento = argumento;
		this.primitiva = false;
	}
	
	public Polar (final Binario binario) {
		final Polar polar = binario.aPolar();
		this.modulo = polar.getModulo();
		this.argumento = polar.getArgumento();
		this.primitiva = false;
	}
	
	public void print() {
		System.out.println("El numero polar es: ["+ modulo + ";" + argumento + "]");
	}
	
	@Override
	public String toString() {
		return "[" + Utils.trimear(modulo) + ";" + Utils.trimear(argumento) + "]";
	}
	
	public Polar aPolar() {
		return this;
	}

	public Binario aBinario() {
		double imaginaria = 0;		
		final double real = modulo*Math.cos(argumento);
		if(argumento != Math.PI) {
			imaginaria = modulo*Math.sin(argumento);
		}

		
		//Quizas haya que corregir el argumento antes
		
		return new Binario(real,imaginaria);
		
	}
	
	public Double getModulo() {
		return this.modulo;
	}
	public Double getArgumento() {
		return this.argumento;
	}
	
	public boolean isPrimitiva() {
		return primitiva;
	}
	//-------------------------OPERACIONES------------------------------------
	
	@Override
	public Complejo sumar(final Complejo sumando) {
		final Binario binario = new Binario(this);
		return new Polar((Binario) binario.sumar(sumando));
	}

	@Override
	public Complejo restar(final Complejo sustraendo) {
		final Binario binario = new Binario(this);
		return new Polar((Binario) binario.restar(sustraendo));
	}

	@Override
	public Complejo multiplicar(final Complejo factor) {
		final Polar factorPolar = factor instanceof Polar ? (Polar) factor : new Polar((Binario) factor);
		return new Polar(this.modulo * factorPolar.getModulo(), this.argumento + factorPolar.getArgumento());
	}

	@Override
	public Complejo dividir(final Complejo divisor) {
		final Polar divisorPolar = divisor instanceof Polar ? (Polar) divisor : new Polar((Binario) divisor);
		if(divisorPolar.getModulo() == 0) {
			return null;
		}
		return new Polar(this.modulo / divisorPolar.getModulo(), this.argumento - divisorPolar.getArgumento());
	}

	@Override
	public Complejo elevarA(final Integer exponente) {
		return new Polar(Math.pow(this.modulo, exponente), corregirArgumento(this.argumento * exponente));
	}
	
	@Override
	public ArrayList<Complejo> raiz(final Integer indice) {
		
		ArrayList <Complejo> resultado = new ArrayList<Complejo>(indice);
		
		double moduloRaiz = Math.pow(this.modulo, 1/indice);
		
		int k;
		for(k=0;k<indice;k++) {
			Polar raiz = new Polar(moduloRaiz, (this.argumento +2*k*Math.PI)/indice);
			
			if (Utils.mcd(k, indice)==1) {
				raiz.primitiva = true;
			}
			
			resultado.add(raiz);
		}
		
		return resultado;
	}
	
private double corregirArgumento(double argumento) {
		
		//Si es menor a 0 suma 2pi hasta llegar al primer giro, si es mayor, resta.
		if(argumento < 0) {
			argumento = corregirArgumentoMenor(argumento);
		}else if(argumento > 2*Math.PI) {
			argumento = corregirArgumentoMayor(argumento);
		}
		return argumento;
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

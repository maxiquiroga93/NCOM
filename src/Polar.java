
public class Polar implements Complejo {
	
	double modulo=0;
	double argumento=0;
	
	public Polar(double modulo, double argumento) {
		this.modulo = modulo;
		this.argumento = argumento;
	}
	
	public void print() {
		System.out.println("El numero polar es: ["+ modulo + ";" + argumento + "]");
	}
	
	public Polar aPolar() {
		return this;
	}

	public Binario aBinario() {
		
		double real = modulo*Math.cos(argumento);
		double imaginaria = modulo*Math.sin(argumento);
		
		//Quizas haya que corregir el argumento antes
		
		return new Binario(real,imaginaria);
		
	}

}

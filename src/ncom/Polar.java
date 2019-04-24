package ncom;

public class Polar implements Complejo {
	
	double modulo=0;
	double argumento=0;
	
	public Polar(final double modulo, final double argumento) {
		this.modulo = modulo;
		this.argumento = argumento;
	}
	
	public Polar (final Binario binario) {
		final Polar polar = binario.aPolar();
		this.modulo = polar.getModulo();
		this.argumento = polar.getArgumento();
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
		
		final double real = modulo*Math.cos(argumento);
		final double imaginaria = modulo*Math.sin(argumento);
		
		//Quizas haya que corregir el argumento antes
		
		return new Binario(real,imaginaria);
		
	}
	
	public Double getModulo() {
		return this.modulo;
	}
	public Double getArgumento() {
		return this.argumento;
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

}

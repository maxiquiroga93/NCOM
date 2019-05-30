package ncom;

import java.util.ArrayList;

public class Fasor implements Complejo {
	
	String tipo = null;
	private double frecuencia = 0;
	private double fase = 0;
	private double amplitud = 0;
	
	
	public Fasor(String tipo, double frecuencia, double fase, double amplitud) {
		this.tipo = tipo;
		this.frecuencia = frecuencia;
		this.fase = fase;
		this.amplitud = amplitud;
	}

	@Override
	public Polar aPolar() {
		Polar polar = new Polar(amplitud,fase);
		return polar;
	}

	@Override
	public Binario aBinario() {
		return this.aPolar().aBinario();
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}

	public String sumar(Fasor sumando) {
		
		if(this.frecuencia != sumando.getFrecuencia()) {
			return "Las frecuencias deben ser iguales";
		}
		
		if(!sumando.getTipo().equals("cos")|| !sumando.getTipo().equals("sen")) {
			return "La funcion a sumar debe ser sinusoidal";
		}
		
		if(this.tipo.equals("cos")) {
			if(!sumando.getTipo().equals(this.tipo)) {
				sumando.setTipo("cos");
				sumando.setFase(sumando.getFase()+Math.PI/2);
			}
			
			Binario resultado = (Binario) this.aBinario().sumar(sumando.aBinario());
			
			return "El resultado es: " + resultado.aPolar().getModulo() + this.tipo + "(" + this.frecuencia + "t+" + resultado.aPolar().getArgumento(); 
		}
		
		if(this.tipo.equals("sen")) {
			if(!sumando.getTipo().equals(this.tipo)) {
				sumando.setTipo("sen");
				sumando.setFase(sumando.getFase()-Math.PI/2);
			}
			
			Binario resultado = (Binario) this.aBinario().sumar(sumando.aBinario());
			
			return "El resultado es: " + resultado.aPolar().getModulo() + this.tipo + "(" + this.frecuencia + "t+" + resultado.aPolar().getArgumento();
		}
		return "La funcion a sumar debe ser sinusoidal";
	}

	@Override
	public Complejo restar(Complejo sustraendo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Complejo multiplicar(Complejo factor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Complejo dividir(Complejo divisor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Complejo elevarA(Integer exponente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Complejo> raiz(Integer indice) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getFrecuencia() {
		return frecuencia;
	}

	public void setFase(double fase) {
		this.fase = fase;
	}

	public double getFase() {
		return fase;
	}

	public double getAmplitud() {
		return amplitud;
	}

	@Override
	public Complejo sumar(Complejo sumando) {
		return null;
	}

}

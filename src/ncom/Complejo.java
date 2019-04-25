package ncom;

public interface Complejo {
	
	Polar aPolar();
	Binario aBinario();
	void print();
	Complejo sumar(final Complejo sumando);
	Complejo restar(final Complejo sustraendo);
	Complejo multiplicar(final Complejo factor);
	Complejo dividir(final Complejo divisor);
	Complejo elevarA(final Integer exponente);
	Complejo raiz(final Integer indice);
}
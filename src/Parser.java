
public class Parser {

	public Parser() {
	}
	
	
	public Complejo parsear(String numero) {
		
		//Si el primer caracter es '(' es Binario.
		if(numero.charAt(0) == '(') {
			//Obtengo el indice de la coma
			int coma = numero.indexOf(',');
			//Desde el parentes hasta la coma, la parte real
			double real = Double.parseDouble(numero.substring(1, coma));
			//Desde la coma hasta el parentesis, la parte imaginaria
			double imaginaria = Double.parseDouble(numero.substring(coma+1, numero.length()-1));
			//Devuelvo el binario
			return new Binario(real,imaginaria);
		}
		
		//Si el primer caracter es un corchete, es Polar.
		if(numero.charAt(0) == '[') {
			//Obtengo el indice del punto y coma
			int puntoYComa = numero.indexOf(';');
			//Desde el corchete hasta el punto y coma, el modulo
			double modulo = Double.parseDouble(numero.substring(1,puntoYComa));
			//Desde el punto y coma hasta el corchete, el argumento
			double argumento = Double.parseDouble(numero.substring(puntoYComa+1, numero.length()-1));
			//Devuelvo el polar
			return new Polar(modulo,argumento);
		}
		//Si no comienza con parentesis o corchete, devuelve null. Habría que hacer una excepcion supongo.
		return null;
		
		//A tener en cuenta, no se que tanta atencion le pondran a ésta parte, pero éste parser puede romper por
		//varios lados. Ya que puedo poner 2 comas, puedo poner 2 puntos y comas, 2 corchetes. Es decir, es muy simple
		//como para evitar que el usuario pueda poner cualquier cosa. Por ahora es para probar.
		
	}
	

}

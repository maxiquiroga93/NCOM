package ncom;

public class Utils {

	public static String trimear(final Double num) {
		final String rta = String.valueOf(num);
		final int indicePunto = rta.indexOf(".");
		final String parteDecimal = rta.substring(indicePunto + 1);
		if(Long.valueOf(parteDecimal) == 0) {
			return rta.substring(0,indicePunto);
		}
		return rta;
	}
	
	public static int mcd(int a, int b) {
		
		if (b==0) return a;
		return mcd(b,a%b);
		
	}
	
}

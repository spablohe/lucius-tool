package es.usal.tfm.lucius.informacion.utils;

public class InformacionUtils {

	public InformacionUtils() {
		super();
	}
	
	public static double fijarNumero(double numero, int digitos) {
        double resultado;
        resultado = numero * Math.pow(10, digitos);
        resultado = Math.round(resultado);
        resultado = resultado/Math.pow(10, digitos);
        return resultado;
    }

}

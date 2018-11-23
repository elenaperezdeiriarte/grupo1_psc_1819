package LNProyecto;

import java.io.Serializable;

public class ClsCD extends ClsAudioVisual implements Serializable
{
	//Esta clase incorpora todas las propiedades que sean propias suyas 
	//ademas de las que tiene por defecto por heredar de ClsArticulo
	//


	/**
	 * 
	 */
	private static final long serialVersionUID = 7980924857008662778L;


	public ClsCD (String nombre, int numero, String autor, int duracion, int ano, double nota, int estado, int contador, int numVotos, int tipo, String web, String imagen)
	{
		super (nombre, numero, autor, duracion, ano, nota, estado, contador, numVotos, tipo, web, imagen);
	}

	
	public String toString()
	{
		StringBuffer salida = new StringBuffer();
		
		String texto = super.toString();
		salida.append("El CD");
		salida.append(texto);
		
		return salida.toString();
	}
		
}

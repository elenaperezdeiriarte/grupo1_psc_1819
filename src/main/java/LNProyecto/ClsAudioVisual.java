package LNProyecto;

import java.io.Serializable;

import org.apache.log4j.Logger;

public class ClsAudioVisual extends ClsArticulo implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int duracion; //Minutos!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	private int ano; 
	private static final Logger log = Logger.getLogger(ClsAudioVisual.class.getName());
	
	
	public ClsAudioVisual (String nombre, int numero, String autor, int duracion, int ano, double nota, int estado, int contador, int numVotos, int tipo, String web, String imagen)
	{
		super (numero, nombre, autor, nota, estado, contador, numVotos, tipo, web, imagen);
		this.duracion = duracion;
		this.ano = ano;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public String toString()
	{
		StringBuffer salida = new StringBuffer();
		
		String texto = super.toString();
		salida.append(texto);
		salida.append(" es del a�o ");
		salida.append(this.ano);
		salida.append(" y tiene una duracion ");
		salida.append(this.duracion);
		salida.append(" segundos ");
		
		return salida.toString();
	}
		
}

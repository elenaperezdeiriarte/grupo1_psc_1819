package LNProyecto;

import java.io.Serializable;

import org.apache.log4j.Logger;

public class ClsCD extends ClsAudioVisual implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7980924857008662778L;
	private static final Logger log = Logger.getLogger(ClsCD.class.getName());
	
	
	
	IMusicBrainz db;

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
	

	public boolean isValidAuthor(String nombre)
	{
		return db.isValidAuthor(nombre);
	}
	
	public boolean isValidSong(String song)
	{
		return db.isValidSong(song);
	}
	
	public IMusicBrainz getBrainz()
	{
		return db;
	}
	
	public void setBrainz (IMusicBrainz db)
	{
		this.db = db;
	}
}

package LNProyecto;

import java.io.Serializable;

import org.apache.log4j.Logger;


//Esta clase incorpora todas las propiedades que sean propias suyas 
//ademas de las que tiene por defecto por heredar de ClsArticulo

public class ClsDVD extends ClsAudioVisual implements Serializable
{

	private static final long serialVersionUID = 1L;
	private int oscar;
	private static final Logger log = Logger.getLogger(ClsDVD.class.getName());
	Iimdb db;
	
	public ClsDVD (String nombre, int numero, String autor, int duracion, int ano, double nota, int estado, int contador, int oscar, int numVotos, int tipo, String web, String imagen)
	{
		super (nombre, numero, autor, duracion, ano, nota, estado, contador, numVotos, tipo, web, imagen);
		this.oscar = oscar;
	}

	public int getOscar() {
		return oscar;
	}

	public void setOscar(int oscar) {
		this.oscar = oscar;
	}	
	
	public String toString()
	{
		StringBuffer salida = new StringBuffer();
		
		String texto = super.toString();
		salida.append("El DVD");
		salida.append(texto);
		salida.append(" tiene ");
		salida.append(oscar);
		salida.append(" oscar(s)");
		
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
	
	public Iimdb getBrainz()
	{
		return db;
	}
	
	public void setBrainz (Iimdb db)
	{
		this.db = db;
	}
}

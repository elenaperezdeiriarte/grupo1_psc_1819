package LNProyecto;

import java.io.Serializable;

public class ClsSugerencias implements Serializable
{
	private static final long serialVersionUID = 8684936469815067072L;
	private String nombre;
	private String autor;
	private String tipo;
	
	//ver sugerencias

	public ClsSugerencias (String nombre, String autor, String tipo)
	{
		this.nombre = nombre;
		this.autor = autor;	
		this.setTipo(tipo);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String toString() 
	{
		return  "El " + tipo + " " + nombre + " cuyo autor es " + autor;
	}

	
	
}

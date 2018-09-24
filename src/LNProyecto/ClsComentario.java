package LNProyecto;

import java.io.Serializable;

public class ClsComentario implements Serializable
{
	private static final long serialVersionUID = 5651789084653031818L;
	private int numeroDeArticulo;
	private String comentario;
	
	public ClsComentario(int numero, String comentario)
	{
		this.numeroDeArticulo=numero;
		this.comentario=comentario;
	}

	@Override
	public String toString() {
		return comentario;
	}

	public int getNumeroDeArticulo() {
		return numeroDeArticulo;
	}

	public void setNumeroDeArticulo(int numeroDeArticulo) {
		this.numeroDeArticulo = numeroDeArticulo;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
}

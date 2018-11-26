package LNProyecto;

import java.io.Serializable;

import org.apache.log4j.Logger;

public class ClsLibro extends ClsArticulo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int paginas;
	private static final Logger log = Logger.getLogger(ClsLibro.class.getName());

	public ClsLibro(String nombre, int numero, String autor, double nota,
			int estado, int contador, int paginas, int numVotos, int tipo,
			String web, String imagen) {
		super(numero, nombre, autor, nota, estado, contador, numVotos, tipo,
				web, imagen);
		this.paginas = paginas;
	}

	public int getpaginas() {
		return paginas;
	}

	public void setpaginas(int paginas) {
		this.paginas = paginas;
	}

	public String toString() {
		StringBuffer salida = new StringBuffer();

		String texto = super.toString();
		salida.append("El libro");
		salida.append(texto);
		salida.append(" tiene ");
		salida.append(paginas);
		salida.append(" paginas");

		return salida.toString();
	}
}

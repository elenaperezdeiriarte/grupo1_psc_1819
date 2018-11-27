package LNProyecto;

import java.io.Serializable;

import org.apache.log4j.Logger;

public class ClsContrasena implements Serializable {
	// Guardar nueva contrase�a
	/**
	 * 
	 */
	private static final long serialVersionUID = -8117488486595992746L;
	private String contrasena;
	private static final Logger log = Logger.getLogger(ClsContrasena.class.getName());

	public ClsContrasena(String contranueva) {
		this.setContrasena(contranueva);
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String toString() {
		String texto = this.contrasena;
		return texto;
	}
}

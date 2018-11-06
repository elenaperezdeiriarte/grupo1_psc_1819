package LNProyecto;

import java.io.Serializable;

public class ClsContrasena implements Serializable {
	// Guardar nueva contraseña
	/**
	 * 
	 */
	private static final long serialVersionUID = -8117488486595992746L;
	private String contrasena;

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

package LNProyecto;

import org.apache.log4j.Logger;

public class MiExcepcion extends Exception {

	private static final long serialVersionUID = 3921881535739240790L;
	private static final Logger log = Logger.getLogger(MiExcepcion.class.getName());

	public String toString() {
		return "El articulo ya existe";
	}

	public String getMessage() {
		return "No has seleccionado ningun art�culo";
	}

}

package LNProyecto;

public class MiExcepcion extends Exception {

	private static final long serialVersionUID = 3921881535739240790L;

	public String toString() {
		return "El articulo ya existe";
	}

	public String getMessage() {
		return "No has seleccionado ningun artículo";
	}

}

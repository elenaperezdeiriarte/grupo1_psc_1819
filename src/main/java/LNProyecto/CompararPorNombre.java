package LNProyecto;

//Clase que sirve para realizar la funcion de comparar articulos por nombre.
import java.util.Comparator;

import org.apache.log4j.Logger;

public class CompararPorNombre implements Comparator<ClsArticulo> {
	private static final Logger log = Logger.getLogger(CompararPorNombre.class.getName());
	public int compare(ClsArticulo o1, ClsArticulo o2) {

		if (o1.getNombre().toLowerCase()
				.compareTo(o2.getNombre().toLowerCase()) == 0) {
			return o1.getAutor().toLowerCase()
					.compareTo(o2.getAutor().toLowerCase());
		}

		return o1.getNombre().toLowerCase()
				.compareTo(o2.getNombre().toLowerCase());
	}
}

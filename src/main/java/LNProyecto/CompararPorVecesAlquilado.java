package LNProyecto;

//Clase que permite la funcionalidad de comparar articulos por veces prestado.
import java.util.Comparator;

import org.apache.log4j.Logger;

public class CompararPorVecesAlquilado implements Comparator<ClsArticulo> {
	private static final Logger log = Logger.getLogger(CompararPorVecesAlquilado.class.getName());
	public int compare(ClsArticulo o1, ClsArticulo o2) {
		if (o1.getContador() > o2.getContador())
			return -1;
		if (o1.getContador() < o2.getContador())
			return 1;

		return 0;
	}
}

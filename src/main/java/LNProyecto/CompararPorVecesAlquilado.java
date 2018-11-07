package LNProyecto;

//Clase que permite la funcionalidad de comparar articulos por veces prestado.
import java.util.Comparator;

public class CompararPorVecesAlquilado implements Comparator<ClsArticulo> {
	public int compare(ClsArticulo o1, ClsArticulo o2) {
		if (o1.getContador() > o2.getContador())
			return -1;
		if (o1.getContador() < o2.getContador())
			return 1;

		return 0;
	}
}

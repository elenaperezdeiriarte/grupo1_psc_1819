package LNProyecto;

//Clase que permite la comparacion por nota de los articulos.
//
import java.util.Comparator;

import org.apache.log4j.Logger;

public class CompararPorNota implements Comparator<ClsArticulo>
{
	private static final Logger log = Logger.getLogger(CompararPorNota.class.getName());
	//Compara dos objetos artículo
		public int compare(ClsArticulo o1, ClsArticulo o2)
		{			
			if(o1.getNota()>o2.getNota()) return -1;
			if(o1.getNota()<o2.getNota()) return 1;
					
			return 0;

		}
}

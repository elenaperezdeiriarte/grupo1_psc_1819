package LNProyecto;


import java.util.Comparator;

public class CompararPorNota implements Comparator<ClsArticulo>
{
		public int compare(ClsArticulo o1, ClsArticulo o2)
		{			
			if(o1.getNota()>o2.getNota()) return -1;
			if(o1.getNota()<o2.getNota()) return 1;
					
			return 0;

		}
}

package LNProyecto;


import java.util.Comparator;

public class CompararPorNombre implements Comparator<ClsArticulo>
{
		public int compare(ClsArticulo o1, ClsArticulo o2)
		{
			
	        if (o1.getNombre().toLowerCase().compareTo(o2.getNombre().toLowerCase())==0) 
	        {  
	        	return o1.getAutor().toLowerCase().compareTo(o2.getAutor().toLowerCase());
	        }
	        
	        return o1.getNombre().toLowerCase().compareTo(o2.getNombre().toLowerCase());
		}
}

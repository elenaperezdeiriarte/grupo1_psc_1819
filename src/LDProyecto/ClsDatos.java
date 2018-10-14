package LDProyecto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import static LNProyecto.ClsConstantes.enFicDatos;

public class ClsDatos
{
	private final String fic_numerador = "src\\numerador.dat";
	private final String fic_contrasena = "src\\contrasena.dat";
	private final String fic_articulos = "src\\articulos.dat";
	private final String fic_sugerencias = "src\\sugerencias.dat";
	private final String fic_bloqueo = "src\\bloqueo.dat";
	private final String fic_queja = "src\\queja.dat";
	private final String fic_comentarios = "src\\comentarios.dat";
	
	
	ObjectOutputStream oos;
	ObjectInputStream ois; 
	AppendableObjectOutputStream aos;
	
	
	
	private String setFichero (enFicDatos fichero)
	{
		//Seg�n el fichero sobre el que se quiera trabajar, se selecciona la ruta.
		
		switch(fichero)
		{
			case FICHERO_DATOS_COMENTARIOS:
			{
				return fic_comentarios;
			}
			case FICHERO_DATOS_ARTICULOS:
			{
				return fic_articulos;
			}
			case FICHERO_DATOS_QUEJA:
			{
				return fic_queja;
			}
			case FICHERO_DATOS_SUGERENCIA:
			{
				return fic_sugerencias;
			}
			case FICHERO_DATOS_CONTRASENA:
			{
				return fic_contrasena;
			}
			case FICHERO_DATOS_NUMERADOR:
			{
				return fic_numerador;
			}
			case FICHERO_DATOS_BLOQUEO:
			{
				return fic_bloqueo;
			}
			
		}
		return "";
	}
	
	public void ComenzarSave(enFicDatos fichero)
	{
		//Guardamos fichero (contrasena en este caso)
		
		String ruta=setFichero(fichero);
		File fic;
		
		//se comprueba si el fichero existe o es la primera vez.
		fic=new File(ruta);
		//Si el fichero existe se deber�n a�adir registros. En caso contrario se deber� de crear el fichero
		if(fic.exists())
		{
			try {
				aos = new AppendableObjectOutputStream(new FileOutputStream(fic,true));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else
		{
			
			try
			{
				fic.createNewFile();
				oos = new ObjectOutputStream(new FileOutputStream(fic));
			} catch (FileNotFoundException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	public void TerminarSave()
	{
		try
		{
			if (oos!=null) oos.close();
			else if(aos!=null)aos.close();
			
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  // Se cierra al terminar.
	}
	public void Save(Serializable o)
	{
		
	
		try
		{
			if(oos!=null) 
				oos.writeObject(o);
			else
			{
				if(aos!=null)	
				{
					
					aos.writeObject(o);
				}
			}
			
		
		} 
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ComenzarRead(enFicDatos fichero) throws IOException 
	{
		String ruta=setFichero(fichero);
		File fic;
		
		fic=new File(ruta);
		if (fic.exists())
		{
			try
			{
				ois = new ObjectInputStream(new FileInputStream(fic));
			} catch (FileNotFoundException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			throw new IOException();
		}
	}
		
	
	public void TerminarRead()
	{
		try
		{
			if(ois!=null)ois.close();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<Serializable> Read()
	{
		
		ArrayList<Serializable>lista;
		Serializable o=null;
		
		
		lista=new ArrayList<Serializable>();
		try
		{
			
			while ((o = (Serializable)ois.readObject()) != null) 
			{
			       lista.add(o);        
			}
		} 
		catch (IOException e)
		{
			if(o==null) 
			{
				System.out.println(e.getMessage());
			}
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		

		return lista;
	}
		
	public int ReadNumero()
	{
		
		Integer numero = null;
		Serializable o=null;
				
		try
		{
			
			while ((o = (Serializable)ois.readObject()) != null) 
			{
			       numero = (Integer) o ;   
			}
		} 
		catch (IOException e)
		{
			if(o==null) 
			{
				System.out.println(e.getMessage());
			}
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		int num = numero;
		return num;
	}
	
	
	public void ResetFile (enFicDatos fichero)
	{
		String ruta =setFichero(fichero);
		File f=new File(ruta);
		f.delete();
			
	}
	public int ContarGuardados(enFicDatos fichero)
	{
		ArrayList<Serializable> l=null;
		try {
			ComenzarRead(fichero);
			l=Read();
			TerminarRead();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(l!=null)
			return l.size();
		else
			return 0;
	}

	public String ReadContrasena() 
	{
		String contrasena = null;
		Serializable o=null;
				
		try
		{
			
			while ((o = (Serializable)ois.readObject()) != null) 
			{
				contrasena = (String) o ;   
			}
			
		} 
		catch (IOException e)
		{
			if(o==null) 
			{
				System.out.println(e.getMessage());
			}
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return contrasena;
	}
	

}

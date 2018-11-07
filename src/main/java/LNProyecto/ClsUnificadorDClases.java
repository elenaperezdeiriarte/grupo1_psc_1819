package LNProyecto;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

import LDProyecto.ClsDatos;
import LNProyecto.ClsCD;
import LNProyecto.ClsConstantes.enFicDatos;
import LNProyecto.ClsDVD;
import LNProyecto.ClsLibro;
import LNProyecto.ClsArticulo;

public class ClsUnificadorDClases 
{	
	
	public int leerNumerador()
	{
		ClsDatos datos = new ClsDatos();
		enFicDatos constantenum = enFicDatos.FICHERO_DATOS_NUMERADOR;
		int abrirnum = 0;
		
		try 
		{
			datos.ComenzarRead(constantenum);
		} 
		catch (IOException a) 
		{
			abrirnum=1;
		}
		
		int numero;
		if (abrirnum == 0)
		{
			
			ArrayList <Serializable> arrnum = datos.Read();
			String entero = arrnum.get(0).toString();
			numero = Integer.parseInt(entero);
			datos.TerminarRead();
		}
		else
		{
			numero = 1;
		}
		
		return numero;
	}
	
	public void sumarNumerador()
	{		
		ClsUnificadorDClases Gestor = new ClsUnificadorDClases();
		int numero = Gestor.leerNumerador();
		numero++;
		ClsNumerador num = new ClsNumerador();
		num.setNumerador(numero);
		
		ClsDatos datos = new ClsDatos();
		enFicDatos constantenum = enFicDatos.FICHERO_DATOS_NUMERADOR;
		datos.ResetFile(constantenum);
		datos.ComenzarSave(constantenum); 	
		datos.Save(num); 						
		datos.TerminarSave();
	}
	
	public void NuevoCD (String nombre, int numero, String autor, int duracion, int ano, double nota, int estado, int contador, int numVotos, int tipo, String web, String imagen) throws MiExcepcion
	{
		
		ClsCD cdnuevo = new ClsCD(nombre, numero, autor, duracion, ano, nota, estado, contador, numVotos, tipo, web, imagen);
		HashSet <ClsArticulo> ListaArticulos = new HashSet <ClsArticulo>();
		ClsUnificadorDClases Gestor = new ClsUnificadorDClases();
		ListaArticulos = Gestor.ArrToHash(Gestor.leerArticulos());
		
		if (ListaArticulos.add(cdnuevo))
		{
			ListaArticulos.add(cdnuevo);
			Gestor.guardarArticulos(Gestor.HashToArr(ListaArticulos));
		}
		else
		{
			throw new MiExcepcion();
		}
	}
	
	public void NuevoDVD (String nombre, int numero, String autor, int duracion, int ano, double nota, int estado, int contador, int oscar, int numVotos, int tipo, String web, String imagen) throws MiExcepcion
	{
		ClsDVD dvdnuevo = new ClsDVD(nombre, numero, autor, duracion, ano, nota, estado, contador, oscar, numVotos, tipo, web, imagen);
		HashSet <ClsArticulo> ListaArticulos = new HashSet <ClsArticulo>();
		ClsUnificadorDClases Gestor = new ClsUnificadorDClases();
		ListaArticulos = Gestor.ArrToHash(Gestor.leerArticulos());
		
		if (ListaArticulos.add(dvdnuevo))
		{
			ListaArticulos.add(dvdnuevo);
			Gestor.guardarArticulos(Gestor.HashToArr(ListaArticulos));
		}
		else
		{
			throw new MiExcepcion();
		}
	}
	
	public void NuevoLibro(String nombre, int numero, String autor, double nota,int estado, int contador, int paginas, int numVotos, int tipo, String web, String imagen) throws MiExcepcion
	{
		ClsLibro libronuevo = new ClsLibro(nombre, numero, autor, nota, estado, contador, paginas, numVotos, tipo, web, imagen);
		HashSet <ClsArticulo> ListaArticulos = new HashSet <ClsArticulo>();
		ClsUnificadorDClases Gestor = new ClsUnificadorDClases();
		ListaArticulos = Gestor.ArrToHash(Gestor.leerArticulos());
		
		if (ListaArticulos.add(libronuevo))
		{
			ListaArticulos.add(libronuevo);
			Gestor.guardarArticulos(Gestor.HashToArr(ListaArticulos));
		}
		else
		{
			throw new MiExcepcion();
		}
	}
	
	public void NuevaSugerencia(String nombre, String autor, String tipo)
	{
		ArrayList <ClsSugerencias> ListaSug = new ArrayList <ClsSugerencias>();
		ClsSugerencias Suger = new ClsSugerencias(nombre, autor, tipo);
		ClsUnificadorDClases Gestor = new ClsUnificadorDClases();
		ListaSug = Gestor.leerSugerencias();
		ListaSug.add(Suger);
		Gestor.guardarSugerencias(ListaSug);
		
	}
	
	public void NuevoComentario(String comentario, int articulo)
	{
		ArrayList <ClsComentario> ListaCom = new ArrayList <ClsComentario>();
		ClsComentario Suger = new ClsComentario(articulo, comentario);
		ClsUnificadorDClases Gestor = new ClsUnificadorDClases();
		ListaCom = Gestor.leerComentarios();
		ListaCom.add(Suger);
		Gestor.guardarComentarios(ListaCom);
		
	}
	
	public void NuevaQueja(String queja)
	{
		ArrayList <ClsQuejas> ListaQuej = new ArrayList <ClsQuejas>();
		ClsQuejas Queja = new ClsQuejas(queja);
		ClsUnificadorDClases Gestor = new ClsUnificadorDClases();
		ListaQuej = Gestor.leerQuejas();
		ListaQuej.add(Queja);
		Gestor.guardarQuejas(ListaQuej);
				
	}
	
	public ArrayList<ClsArticulo> leerArticulos()
	{
		int abrir = 0;
		ClsDatos datos = new ClsDatos();
		ArrayList<ClsArticulo> ListaArticulos = new ArrayList<ClsArticulo>();
		
		try 
		{
			datos.ComenzarRead(enFicDatos.FICHERO_DATOS_ARTICULOS);  
		}
		catch (IOException e1)
		{
			abrir=1;
		}	
		if (abrir == 0)
		{
			ArrayList <Serializable> ArrayAux1 = datos.Read();	
			@SuppressWarnings("unchecked")
			ArrayList <Serializable> ArrayAux2 = (ArrayList <Serializable>) ArrayAux1.get(0);
			
			for (Serializable s : ArrayAux2)	
			{
				try
				{
				ListaArticulos.add((ClsCD)s);
				}
				catch (ClassCastException e)
				{
					try
					{
					ListaArticulos.add((ClsDVD)s);
					}
					catch (ClassCastException e1)
					{
						ListaArticulos.add((ClsLibro)s);
					}
				}
			}
			datos.TerminarRead();
		}
		return ListaArticulos;
	}
	
	public ArrayList<ClsSugerencias> leerSugerencias()
	{
		ClsDatos datos = new ClsDatos();
		ArrayList<ClsSugerencias> ListaSug = new ArrayList<ClsSugerencias>();
				
		int abrir = 0;
		try 
		{
			datos.ComenzarRead(enFicDatos.FICHERO_DATOS_SUGERENCIA);  
		}
		catch (IOException e1)
		{
			abrir = 1;
		}
				
		if (abrir == 0)
		{
			ArrayList <Serializable> ArraySug1 = datos.Read();	
			@SuppressWarnings("unchecked")
			ArrayList <Serializable> ArraySug = (ArrayList <Serializable>) ArraySug1.get(0);
			
			for (Serializable s : ArraySug)	
			{
				ListaSug.add((ClsSugerencias)s);
				
			}
			datos.TerminarRead();
		}
		
		return ListaSug;
	}
	
	public ArrayList<ClsQuejas> leerQuejas()
	{
		ClsDatos datos = new ClsDatos();
		ArrayList<ClsQuejas> ListaQuej = new ArrayList<ClsQuejas>();
		
		int abrir = 0;
		try 
		{
			datos.ComenzarRead(enFicDatos.FICHERO_DATOS_QUEJA);  
		}
		catch (IOException e1)
		{
			abrir=1;
		}
				
		if (abrir == 0)
		{
			ArrayList <Serializable> ArrayQuej1 = datos.Read();	
			@SuppressWarnings("unchecked")
			ArrayList <Serializable> ArrayQuej = (ArrayList <Serializable>) ArrayQuej1.get(0);
			
			for (Serializable s : ArrayQuej)	
			{
				ListaQuej.add((ClsQuejas)s);
				
			}
			datos.TerminarRead();
		}
		return ListaQuej;
	}
	
	public ArrayList<ClsComentario> leerComentarios()
	{
		ClsDatos datos = new ClsDatos();
		ArrayList<ClsComentario> ListaComent = new ArrayList<ClsComentario>();
		
		int abrir = 0;
		try 
		{
			datos.ComenzarRead(enFicDatos.FICHERO_DATOS_COMENTARIOS);  
		}
		catch (IOException e1)
		{
			abrir=1;
		}
				
		if (abrir == 0)
		{
			ArrayList <Serializable> ArrayCom1 = datos.Read();	
			@SuppressWarnings("unchecked")
			ArrayList <Serializable> ArrayCom = (ArrayList <Serializable>) ArrayCom1.get(0);
			
			for (Serializable s : ArrayCom)	
			{
				ListaComent.add((ClsComentario)s);
				
			}
			datos.TerminarRead();
		}
		return ListaComent;
	}
	
	public void guardarArticulos (ArrayList <ClsArticulo> ListaArticulos)
	{
		ClsDatos datos = new ClsDatos();
		datos.ResetFile(enFicDatos.FICHERO_DATOS_ARTICULOS);
		datos.ComenzarSave(enFicDatos.FICHERO_DATOS_ARTICULOS);
		datos.Save(ListaArticulos);
		datos.TerminarSave();
	}
	
	public void guardarSugerencias (ArrayList <ClsSugerencias> ListaSugerencias)
	{
		ClsDatos datos = new ClsDatos();
		datos.ResetFile(enFicDatos.FICHERO_DATOS_SUGERENCIA);
		datos.ComenzarSave(enFicDatos.FICHERO_DATOS_SUGERENCIA);
		datos.Save(ListaSugerencias);
		datos.TerminarSave();
	}
	
	public void guardarComentarios (ArrayList <ClsComentario> ListaComentarios)
	{
		ClsDatos datos = new ClsDatos();
		datos.ResetFile(enFicDatos.FICHERO_DATOS_COMENTARIOS);
		datos.ComenzarSave(enFicDatos.FICHERO_DATOS_COMENTARIOS);
		datos.Save(ListaComentarios);
		datos.TerminarSave();
	}
	
	public void guardarQuejas (ArrayList <ClsQuejas> ListaQuejas)
	{
		ClsDatos datos = new ClsDatos();
		datos.ResetFile(enFicDatos.FICHERO_DATOS_QUEJA);
		datos.ComenzarSave(enFicDatos.FICHERO_DATOS_QUEJA);
		datos.Save(ListaQuejas);
		datos.TerminarSave();
	}
	
	public HashSet<ClsArticulo> ArrToHash (ArrayList<ClsArticulo> ListaArticulos)
	{
		HashSet<ClsArticulo> HashArticulos = new HashSet<ClsArticulo>();
		
		for(ClsArticulo a: ListaArticulos)
		{
			HashArticulos.add(a);
		}
		
		return HashArticulos;
	}
	
	public ArrayList<ClsArticulo> HashToArr (HashSet<ClsArticulo> HashArticulos)
	{
		ArrayList<ClsArticulo> ListaArticulos = new ArrayList<ClsArticulo>();
		
		for(ClsArticulo a: HashArticulos)
		{
			ListaArticulos.add(a);
		}
		
		return ListaArticulos;
	}
	
	public void comenzarModificacion(ClsArticulo Articulo)
	{
		ArrayList <ClsArticulo> ArticuloList2 = new ArrayList<ClsArticulo>();
		ClsUnificadorDClases cambio = new ClsUnificadorDClases();
		ArticuloList2 = cambio.leerArticulos();
		
		ClsArticulo ArticuloAComparar = Articulo;
		
		int abridor = -1;
		
		
		
		for (int z = 0; z<ArticuloList2.size(); z++)
		{		
			if(ArticuloList2.get(z).getNombre().equals(ArticuloAComparar.getNombre()))
				if(ArticuloList2.get(z).getAutor().equals(ArticuloAComparar.getAutor()))
					if(ArticuloList2.get(z).getTipo()==ArticuloAComparar.getTipo())
							abridor = z;
		}	
		
		if(abridor!=-1)
		{
		ArticuloList2.remove(abridor);
		cambio.guardarArticulos(ArticuloList2);
		}
	}
	
	@SuppressWarnings("unused")
	public void Modificar(ClsArticulo Articulo, int alq0mod0punt, int punt, String webnuev, String imagnuev) throws MiExcepcion
	{
		int elegir = 0;
		try
		{
			ClsCD CD = (ClsCD) Articulo;
		}
		catch(ClassCastException e)
		{
			try
			{
				ClsDVD DVD = (ClsDVD) Articulo;
				elegir = 1;
			}
			catch(ClassCastException a)
			{
				ClsLibro Libro = (ClsLibro) Articulo;
				elegir = 2;
			}
		}
		
		ClsUnificadorDClases cambio = new ClsUnificadorDClases();
		
		switch(elegir)
		{		
		case 0:
					ClsCD CDaModificar =(ClsCD) Articulo;
						
					int numero = CDaModificar.getNumero();
					double nota = CDaModificar.getNota();
					int estado = CDaModificar.getEstado(), contador= CDaModificar.getContador(), numVotos = CDaModificar.getNumVotos();
					String nombre = CDaModificar.getNombre();
					String autor = CDaModificar.getAutor();
					int duracion = CDaModificar.getDuracion();
					int ano =CDaModificar.getAno();
					int tipo = CDaModificar.getTipo();
					String web = CDaModificar.getWeb();
					String imagen = CDaModificar.getImagen();
					
					if(alq0mod0punt==0)
					{
						if (estado == 1)
						{
							estado=0;
						}
						else
						{
							estado=1;
							contador++;
						}
					}
					if(alq0mod0punt==1)
					{
						double totalpuntos = nota*numVotos;
						numVotos++;
						double puntfinal = (totalpuntos + punt)/numVotos;
						nota = puntfinal;
					}
					if(alq0mod0punt==3)
					{
						web = webnuev;
					}
					
					if(alq0mod0punt==4)
					{
						imagen = imagnuev;
					}
						
					cambio.NuevoCD(nombre, numero, autor, duracion, ano, nota, estado, contador, numVotos, tipo, web, imagen);
					
					break;
		case 1:
					ClsDVD DVDaModificar = (ClsDVD)Articulo;
					int numero1 = DVDaModificar.getNumero();
					double nota1 = DVDaModificar.getNota();
					int estado1 = DVDaModificar.getEstado(), contador1= DVDaModificar.getContador(), numVotos1 = DVDaModificar.getNumVotos();
					String nombre1 = DVDaModificar.getNombre();
					String autor1 = DVDaModificar.getAutor();
					int duracion1 = DVDaModificar.getDuracion(), ano1 =DVDaModificar.getAno(), oscar = DVDaModificar.getOscar(), tipo1=DVDaModificar.getTipo();
					String web1 = DVDaModificar.getWeb();
					String imagen1 = DVDaModificar.getImagen();
				
					if(alq0mod0punt==0)
					{
						if (estado1 == 1)
						{
							estado1=0;
						}
						else
						{
							estado1=1;
							contador1++;
						}
					}
					if(alq0mod0punt==1)
					{
						double totalpuntos = nota1*numVotos1;
						numVotos1++;
						double puntfinal = (totalpuntos + punt)/numVotos1;
						nota1 = puntfinal;
					}
					if(alq0mod0punt==3)
					{
						web1 = webnuev;
					}
					if(alq0mod0punt==4)
					{
						imagen1 = imagnuev;
					}
					
					cambio.NuevoDVD(nombre1, numero1, autor1, duracion1, ano1, nota1, estado1, contador1, oscar, numVotos1, tipo1, web1, imagen1);
					
					break;
		
		case 2:
					ClsLibro LibroaModificar = (ClsLibro) Articulo;
					
					int numero11 = LibroaModificar.getNumero();
					double nota11 = LibroaModificar.getNota();
					int estado11 = LibroaModificar.getEstado(), contador11= LibroaModificar.getContador(), numVotos11 = LibroaModificar.getNumVotos();
					String nombre11 = LibroaModificar.getNombre();
					String autor11 = LibroaModificar.getAutor();
					int paginas = LibroaModificar.getpaginas();
					int tipo11 = LibroaModificar.getTipo();
					String web11 = LibroaModificar.getWeb();
					String imagen11 = LibroaModificar.getImagen();
					
					if(alq0mod0punt==0)
					{
						if (estado11 == 1)
						{
							estado11=0;
						}
						else
						{
							estado11=1;
							contador11++;
						}
					}
					
					if(alq0mod0punt==1)
					{
						double totalpuntos = nota11*numVotos11;
						numVotos11++;
						double puntfinal = (totalpuntos + punt)/numVotos11;
						nota11 = puntfinal;
					}
					
					if(alq0mod0punt==3)
					{
						web11 = webnuev;
					}
					
					if(alq0mod0punt==4)
					{
						imagen11 = imagnuev;
					}
					
					cambio.NuevoLibro(nombre11, numero11, autor11, nota11, estado11, contador11, paginas, numVotos11, tipo11, web11, imagen11);
					
					break;	
		}
	}
	
	public String leerContra()
	{
		ClsDatos datos = new ClsDatos();
		String contrasena = null ;
		enFicDatos constantecontra = enFicDatos.FICHERO_DATOS_CONTRASENA;
		int abrircontra = 0;
		try 
		{
			datos.ComenzarRead(constantecontra);  
		}
		catch (IOException e1)
		{
			abrircontra = 1;
		}
				
		if (abrircontra == 0)
		{
			ArrayList <Serializable> cont = datos.Read();		
			contrasena = cont.get(0).toString();
			datos.TerminarRead();										
		}
		else
		{
			contrasena="a";
		}
		return contrasena;
	}
	
	public ClsBloqueo leerBloqueo()
	{
		ClsDatos datos = new ClsDatos();
		ClsBloqueo bloqueo = new ClsBloqueo();
		enFicDatos constantebloq = enFicDatos.FICHERO_DATOS_BLOQUEO;
		
		int abrir = 0;
		try 
		{
			datos.ComenzarRead(constantebloq); 
		}
		catch (IOException e1)
		{
			abrir=1;
		}
		
		if (abrir == 0)
		{
			ArrayList <Serializable> bloq = datos.Read();		
			bloqueo = (ClsBloqueo) bloq.get(0);
			datos.TerminarRead();
		}
		return bloqueo;
	}
	
	public void guardarContra(ClsContrasena contrasena)
	{
		enFicDatos constantecontra = enFicDatos.FICHERO_DATOS_CONTRASENA;
		ClsDatos datos = new ClsDatos();
		
		datos.ResetFile(constantecontra);
		datos.ComenzarSave(constantecontra); 	
		datos.Save(contrasena); 
		datos.TerminarSave();
	}
	
	public void guardarBloqueo(ClsBloqueo bloqueo)
	{
		enFicDatos constantebloq = enFicDatos.FICHERO_DATOS_BLOQUEO;
		ClsDatos datos = new ClsDatos();
		
		datos.ResetFile(constantebloq);
		datos.ComenzarSave(constantebloq); 	
		datos.Save(bloqueo); 
		datos.TerminarSave();
	}
	
	public int intentosBloqueo()
	{
		ClsUnificadorDClases Gestor = new ClsUnificadorDClases();
		ClsBloqueo bloqueo = Gestor.leerBloqueo();
		
		return bloqueo.getIntentos();
	}
	
	public int semaforoBloqueo()
	{
		ClsUnificadorDClases Gestor = new ClsUnificadorDClases();
		ClsBloqueo bloqueo = Gestor.leerBloqueo();
		int semaforo = bloqueo.sacarSemaforo();
		Gestor.guardarBloqueo(bloqueo);
		
		return semaforo;
	}
	
	public void reiniciarIntentos()
	{
		ClsUnificadorDClases Gestor = new ClsUnificadorDClases();
		ClsBloqueo bloqueo = Gestor.leerBloqueo();
		bloqueo.reiniciarIntentos();
		Gestor.guardarBloqueo(bloqueo);
	}
	
	public void sacarMinutos()
	{
		ClsUnificadorDClases Gestor = new ClsUnificadorDClases();
		ClsBloqueo bloqueo = Gestor.leerBloqueo();
		bloqueo.sacarMinutos();
		Gestor.guardarBloqueo(bloqueo);
	}
	
	public void sumarIntento()
	{
		ClsUnificadorDClases Gestor = new ClsUnificadorDClases();
		ClsBloqueo bloqueo = Gestor.leerBloqueo();
		bloqueo.setIntentos();	
		Gestor.guardarBloqueo(bloqueo);
	}

	
	public int getIntentos()
	{
		ClsUnificadorDClases Gestor = new ClsUnificadorDClases();
		ClsBloqueo bloqueo = Gestor.leerBloqueo();
		return bloqueo.getIntentos();
	}

	public long sacarFalta() 
	{
		ClsUnificadorDClases Gestor = new ClsUnificadorDClases();
		ClsBloqueo bloqueo = Gestor.leerBloqueo();
		return bloqueo.sacarFalta();
	}
	
	public void eliminarFichero(enFicDatos fichero)
	{
		ClsDatos datos = new ClsDatos();
		datos.ResetFile(fichero);
	}
	
	public void eliminarSugerencias()
	{
		ClsUnificadorDClases Gestor = new ClsUnificadorDClases();
		Gestor.eliminarFichero(enFicDatos.FICHERO_DATOS_SUGERENCIA);
	}
	
	public void eliminarQuejas()
	{
		ClsUnificadorDClases Gestor = new ClsUnificadorDClases();
		Gestor.eliminarFichero(enFicDatos.FICHERO_DATOS_QUEJA);
	}

	public ArrayList<ClsComentario> leerComentariosArticulo(int numero) 
	{
		ClsUnificadorDClases Gestor = new ClsUnificadorDClases();
		ArrayList <ClsComentario> ListaComentarios = Gestor.leerComentarios();
		ArrayList <ClsComentario> ListaComentariosArticulo = new ArrayList<ClsComentario>();
		
		for(ClsComentario a : ListaComentarios)
		{
			if(a.getNumeroDeArticulo()==numero)
				ListaComentariosArticulo.add(a);
		}
		
		return ListaComentariosArticulo;
	}

	public boolean saberSiComentarios(int numero) 
	{
		ClsUnificadorDClases Gestor = new ClsUnificadorDClases();
		ArrayList <ClsComentario> ListaComentarios = Gestor.leerComentarios();
		
		for(ClsComentario a : ListaComentarios)
		{
			if(a.getNumeroDeArticulo()==numero)
				return true;
		}
		
		return false;
	}

	public void guardarComentario (ArrayList <ClsComentario> ListaComentarios)
	{
		ClsDatos datos = new ClsDatos();
		datos.ResetFile(enFicDatos.FICHERO_DATOS_COMENTARIOS);
		datos.ComenzarSave(enFicDatos.FICHERO_DATOS_COMENTARIOS);
		datos.Save(ListaComentarios);
		datos.TerminarSave();
	}

	public ArrayList<Integer> tamanosColumnas() 
	{
		ArrayList <Integer> tamanos = new ArrayList<Integer>();
		tamanos.add(50);
		tamanos.add(50);
		tamanos.add(300);
		tamanos.add(200);
		tamanos.add(40);
		tamanos.add(60);
		tamanos.add(50);
		
		return tamanos;
	}

}
	
	

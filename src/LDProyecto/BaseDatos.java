package LDProyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import LNProyecto.ClsArticulo;
import LNProyecto.ClsQuejas;
import LNProyecto.ClsSugerencias;

public class BaseDatos {

	// ------------------------------------
	// VALIDO PARA CUALQUIER BASE DE DATOS
	// ------------------------------------
	
	private static Connection connection = null;
	private static Statement statement = null;
	
	public static Connection initBD( String nombreBD ) {
		try {
		    Class.forName("org.sqlite.JDBC");
		    connection = DriverManager.getConnection("jdbc:sqlite:" + nombreBD );
			statement = connection.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
		    return connection;
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog( null, "Error de conexión!! No se ha podido conectar con " + nombreBD , "ERROR", JOptionPane.ERROR_MESSAGE );
			System.out.println( "Error de conexión!! No se ha podido conectar con " + nombreBD );
			return null;
		}
	}
	

	public static void close() {
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static Connection getConnection() {
		return connection;
	}
	
	
	public static Statement getStatement() {
		return statement;
	}

	// ------------------------------------
	// PARTICULAR DEL CATALOGO MULTIMEDIA
	// ------------------------------------


	//////////////////////////////////////
	/////	     Contrasena          /////
	//////////////////////////////////////
	
	public static void crearTablaBDU() 
	{
		if (statement==null) return;
		try 
		{
			statement.executeUpdate("create table CONTRASENA " + "(contra string)");
			
		} catch (SQLException e) {
			// Si hay excepción es que la tabla ya existía (lo cual es correcto)
			// e.printStackTrace();  
		}
	}
	
	public static void eliminarTablaBDU() {
		if (statement==null) return;
		try 
		{
			statement.executeUpdate("drop table CONTRASENA");
		} catch (SQLException e) {
			// Si hay excepción es que la tabla ya existía (lo cual es correcto)
			// e.printStackTrace();  
		}
	}
	
	public static boolean cambiarContra( Statement st, String contra ) throws SQLException 
	{
		try 
		{
			String sentSQL = "insert into CONTRASENA (contra) values('" + contra + "')";
			JOptionPane.showMessageDialog(null, "Contraseña cambiada");
			System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
			int val = st.executeUpdate( sentSQL );
			if (val!=1) return false;  // Se tiene que añadir 1 - error si no
			return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public static void devolverContra() throws SQLException
	{
		
		Statement stmt = connection.createStatement();
		String query = "select contra from CONTRASENA";
		ResultSet rs = stmt.executeQuery(query);
		String contrasena = "";
		while (rs.next())
		{
			contrasena = rs.getString(1);
			System.out.println(contrasena);
		}
		
		contrasena(contrasena);
	}
	
	static String contraAdmin;
	public static void contrasena(String contra)
	{
		contraAdmin = contra;	
	}
	
	public static String getContra()
	{
		return contraAdmin;
	}
	
	//////////////////////////////////////
	/////	        Bloqueo          /////
	//////////////////////////////////////	
	
	public static void crearTablaBDB() 
	{
		if (statement==null) return;
		try 
		{
			statement.executeUpdate("create table BLOQUEO " + "(intento int, milisegundos long)");			
		} 
		catch (SQLException e) 
		{
			// Si hay excepción es que la tabla ya existía (lo cual es correcto)
			// e.printStackTrace();  
		}
	}

	public static void eliminarTablaBDB() {
		if (statement==null) return;
		try 
		{
			statement.executeUpdate("drop table BLOQUEO");
		} catch (SQLException e) {
			// Si hay excepción es que la tabla ya existía (lo cual es correcto)
			// e.printStackTrace();  
		}
	}
	
	public static boolean crearBloqueo( Statement st) throws SQLException 
	{
		try 
		{
			String sentSQL = "insert into BLOQUEO (intento, milisegundos) values(1,0)";
			intentos(1);
			milisegundos(1);
			System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
			int val = st.executeUpdate( sentSQL );
			if (val!=1) return false;  // Se tiene que añadir 1 - error si no
			return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return false;
		}
		
	}
	
	public static boolean updateBloqueo( Statement st) throws SQLException 
	{
		devolverBloqueo();
		int intentos = intentosAdmin + 1;
		
		if(intentos >= 4)
		{
//			java.util.Date d = new java.util.Date();
		    long milis = System.currentTimeMillis() + 60000;
		    
			try 
			{
				String sentSQL = "update BLOQUEO set intento = " + intentos + ", milisegundos = " + milis;
				intentos(intentos);
				milisegundos(milis);
				System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
				int val = st.executeUpdate( sentSQL );
				if (val!=1) return false;  // Se tiene que añadir 1 - error si no
				return true;
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
				return false;
			}
		}
		else
		{
			try 
			{
				String sentSQL = "update BLOQUEO set intento = " + intentos;
				intentos(intentos);
				System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
				int val = st.executeUpdate( sentSQL );
				if (val!=1) return false;  // Se tiene que añadir 1 - error si no
				return true;
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
				return false;
			}
		}
	}
	
	public static void devolverBloqueo() throws SQLException
	{
		
		Statement stmt = connection.createStatement();
		String query = "select intento, milisegundos from BLOQUEO";
		ResultSet rs = stmt.executeQuery(query);
		int intentos = 0;
		long milisegundos = 0;
		while (rs.next())
		{
			intentos = rs.getInt(1);
			milisegundos = rs.getLong(2);
		}
		
		intentos(intentos);
		milisegundos(milisegundos);
	}
	
	static int intentosAdmin;
	public static void intentos(int intentos)
	{
		intentosAdmin = intentos;	
	}
	
	public static int getIntentos()
	{
		return intentosAdmin;
	}
	
	
	static long milisegundosAdmin;
	public static void milisegundos(long milisegundos)
	{
		milisegundosAdmin = milisegundos;	
	}
	
	public static long getMilisegundos()
	{
		return milisegundosAdmin;
	}
	
	//////////////////////////////////////
	/////	       Quejas            /////
	//////////////////////////////////////
	
	public static void crearTablaBDQ() 
	{	
		if (statement==null) return;
		try 
		{
			statement.executeUpdate("create table QUEJAS " + "(texto string)");
		} 
		catch (SQLException e) 
		{
			// Si hay excepción es que la tabla ya existía (lo cual es correcto)
			// e.printStackTrace();  
		}
	}
	
	public static void eliminarTablaBDQ() {
		if (statement==null) return;
		try 
		{
			statement.executeUpdate("drop table QUEJAS");
			arrayQuejas = new ArrayList<ClsQuejas>();
		} 
		catch (SQLException e) 
		{
			// Si hay excepción es que la tabla ya existía (lo cual es correcto)
			// e.printStackTrace();  
		}
	}
	
	public static boolean crearQueja( Statement st, String texto ) throws SQLException 
	{
		try 
		{
			String sentSQL = "insert into QUEJAS (texto) values('" + texto + "')";
			JOptionPane.showMessageDialog(null, "Queja guardada");
			System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
			int val = st.executeUpdate( sentSQL );
			if (val!=1) return false;  // Se tiene que añadir 1 - error si no
			return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public static void selectQuejas() throws SQLException
	{
		
		Statement stmt = connection.createStatement();
		String query = "select texto from QUEJAS";
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next())
		{
			queja(rs.getString(1));
		}
	}
	
	static ArrayList<ClsQuejas> arrayQuejas = new ArrayList<ClsQuejas>();
	public static void queja(String texto)
	{
		ClsQuejas queja = new ClsQuejas(texto);	
		arrayQuejas.add(queja);
	}
	
	public static ArrayList<ClsQuejas> getQuejas()
	{
		return arrayQuejas;
	}

	//////////////////////////////////////
	/////	       Sugerencias       /////
	//////////////////////////////////////
	
	public static void crearTablaBDS() 
	{	
		if (statement==null) return;
		try 
		{
			statement.executeUpdate("create table SUGERENCIAS " + "(nombre string, autor string, tipo string)");
		} 
		catch (SQLException e) 
		{
			// Si hay excepción es que la tabla ya existía (lo cual es correcto)
			// e.printStackTrace();  
		}
	}
	
	public static void eliminarTablaBDS() {
		if (statement==null) return;
		try 
		{
			statement.executeUpdate("drop table SUGERENCIAS");
			arraySugerencia = new ArrayList<ClsSugerencias>();
		} 
		catch (SQLException e) 
		{
			// Si hay excepción es que la tabla ya existía (lo cual es correcto)
			// e.printStackTrace();  
		}
	}
	
	public static boolean crearSugerencia( Statement st, String nombre, String autor, String tipo) throws SQLException 
	{
		try 
		{
			String sentSQL = "insert into SUGERENCIAS (nombre, autor, tipo) values('" + nombre + "', '" + autor + "', '" + tipo + "')";
			JOptionPane.showMessageDialog(null, "Sugerencia guardada");
			System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
			int val = st.executeUpdate( sentSQL );
			if (val!=1) return false;  // Se tiene que añadir 1 - error si no
			return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public static void selectSugerencias() throws SQLException
	{
		
		Statement stmt = connection.createStatement();
		String query = "select nombre, autor, tipo from SUGERENCIAS";
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next())
		{
			sugerencia(rs.getString(1),rs.getString(2),rs.getString(3));
		}
	}
	
	static ArrayList<ClsSugerencias> arraySugerencia = new ArrayList<ClsSugerencias>();
	public static void sugerencia(String nombre, String autor, String tipo)
	{
		ClsSugerencias sugerencia = new ClsSugerencias(nombre, autor, tipo);	
		arraySugerencia.add(sugerencia);
	}
	
	public static ArrayList<ClsSugerencias> getSugerencias()
	{
		return arraySugerencia;
	}

}	




	
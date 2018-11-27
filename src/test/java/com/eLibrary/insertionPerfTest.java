package com.eLibrary;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import LDProyecto.BaseDatos;
import LNProyecto.ClsCD;
import LNProyecto.ClsQuejas;
import LNProyecto.ClsSugerencias;

public class insertionPerfTest {
	ClsCD cdnuevo = new ClsCD("Zapatillas", 1, "El canto del loco", 120, 2005,
			7.0, 0, 3, 5, 0, "www.elcantodelloco,con/zapatillas.html", "www.elcantodelloco.com/imagen.png");

	ClsQuejas queja = new ClsQuejas("Somos unos vividores");
	
	String nuevaContra = "Vividores";
	
	ClsSugerencias sugerencia = new ClsSugerencias("El Mal Querer", "Rosalia", "CD");
	/* TIPOS DE PERFEST
	 * invocations: número de veces que se invocará el @Test
	 * threads: hebras concurrentes sobre las que se distribuirán los invocations
	 * duration: tiempo durante el que se ejecutará el test en bucle (ms)
	 */
	
	
	/* TIPOS DE REQUIRED
	 * throughput: número de ejecuciones por segundo menor que …
	 * average: media del tiempo de ejecución menor que …
	 * median: al menos el 50% de las ejecuciones con un tiempo de ejecución menor 
	 * max: tiempo de ejecución de un test menor que …
	 * totalTime: tiempo total de la ejecución de todos los test menor que …
	 * percentileX: al menos el X% de las ejecuciones con un tiempo de ejecución menor
	 */

	//Activa Contiperf cuando se lanza JUnit

	@Rule
	public ContiPerfRule i = new ContiPerfRule();
	
	
	@Before
	public void setup()
	{
		BaseDatos.initBD("eLibraryTest.db");
		
	}
	/*
	@Test
	@PerfTest(invocations = 1000, threads = 20, duration=2000)   //PerfTest convierte un JUnit en una prueba Contiperf. A definir número de iteraciones y los hilos que se disponen
	@Required(max = 1500, average = 1500, median = 1500)  //Required define las requisitos de rendimiento, si no los cumple --> rojo	
	public void cdInsertionTest() throws Exception {
		//assertNotNull(cdnuevo);
		BaseDatos.crearTablaBDCD();
			try {
				
					BaseDatos.crearCD(BaseDatos.getStatement(), cdnuevo);
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		
		Thread.sleep(1200);
	}
	
	*/
	@Test
	@PerfTest(invocations = 10000, threads = 20, duration=2000)   //PerfTest convierte un JUnit en una prueba Contiperf. A definir número de iteraciones y los hilos que se disponen
	@Required(max = 700, average = 400, median= 300)  //Required define las requisitos de rendimiento, si no los cumple --> rojo	
	public void contraseInsertionTest() throws Exception {
		
		//assertNotNull(cdnuevo);
		//BaseDatos.initBD("eLibraryTest.db");
		BaseDatos.crearTablaBDU();
		try 
		{
			BaseDatos.cambiarContra(BaseDatos.getStatement(), nuevaContra);
		} 
		catch (SQLException e1) 
		{
			e1.printStackTrace();
		}	
	}
	
	
	
	@Test
	@PerfTest(invocations = 10000, threads = 20, duration=2000)   //PerfTest convierte un JUnit en una prueba Contiperf. A definir número de iteraciones y los hilos que se disponen
	@Required(max = 1700, average = 1400, median= 1500)  //Required define las requisitos de rendimiento, si no los cumple --> rojo	
	public void quejasInsertionTest() throws Exception {
		
		//assertNotNull(cdnuevo);
		//BaseDatos.initBD("eLibraryTest.db");
		BaseDatos.crearTablaBDQ();
		try {
			BaseDatos.crearQueja(BaseDatos.getStatement(), queja.getQueja());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		Thread.sleep(1200);
	}
	
	
	@Test
	@PerfTest(invocations = 10000, threads = 20, duration=2000)   //PerfTest convierte un JUnit en una prueba Contiperf. A definir número de iteraciones y los hilos que se disponen
	@Required(max = 1600, average = 1400, median= 1500)  //Required define las requisitos de rendimiento, si no los cumple --> rojo	
	public void sugerenciasInsertionTest() throws Exception {
		
		//BaseDatos.initBD("eLibraryTest.db");
		BaseDatos.crearTablaBDS();
		try {
			BaseDatos.crearSugerencia(BaseDatos.getStatement(),sugerencia.getNombre(), sugerencia.getAutor(),sugerencia.getTipo());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		Thread.sleep(1200);
	}
	
	@After
	public void erase()
	{
		BaseDatos.eliminarTablaBDCD();
		BaseDatos.close();
		System.out.println("Todo ha sido borrado");
	}
	
}

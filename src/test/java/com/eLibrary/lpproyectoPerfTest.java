package com.eLibrary;

import static org.junit.Assert.assertNotNull;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.Test;

import LNProyecto.ClsArticulo;
import LNProyecto.ClsCD;
import LNProyecto.ClsDVD;
import LNProyecto.ClsLibro;
import LPProyecto.Inicio;
import LPProyecto.JFrameCFCD;
import LPProyecto.JFrameCFDVD;
import LPProyecto.JFrameCFLibro;
import LPProyecto.JFrameCambiarContrasena;
import LPProyecto.JFrameEstadisticas;
import LPProyecto.JFrameListaQuejasSugerencias;
import LPProyecto.JFrameMenuAdministrador;
import LPProyecto.JFrameMenuCliente;
import LPProyecto.JFrameMenuPrincipal;
import LPProyecto.JFrameModificarCD;
import LPProyecto.JFrameModificarDVD;
import LPProyecto.JFrameModificarLibro;
import LPProyecto.JFrameQueja;
import LPProyecto.JFrameSugerencia;
import LPProyecto.JFrameVerArticulos;
import LPProyecto.JFrameVerFicha;


//Default performance behavior for all the @Test annotated methods
//@PerfTest(invocations = 5)
//@Required(max = 1200, average = 250)


//Para que se ejecute con el MoneyTest a la vez
//@RunWith(ContiPerfSuiteRunner.class)
//@SuiteClasses(lpproyectoTest.class)

public class lpproyectoPerfTest {

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
	
	@Test
	@PerfTest(invocations = 1000, threads = 20, duration=2000)   //PerfTest convierte un JUnit en una prueba Contiperf. A definir número de iteraciones y los hilos que se disponen
	@Required(max = 3000, average = 2000, median=2000)  //Required define las requisitos de rendimiento, si no los cumple --> rojo
	
	public void fichaTest() throws Exception {
		Thread.sleep(1000);
	}
	
	@Test
	@PerfTest(invocations = 1000, threads = 20, duration=2000)   //PerfTest convierte un JUnit en una prueba Contiperf. A definir número de iteraciones y los hilos que se disponen
	@Required(max = 3000, average = 2000, median=2000)  //Required define las requisitos de rendimiento, si no los cumple --> rojo
	public void inicioTest() throws Exception {
		Thread.sleep(1000);
	}
	
	@Test
	@PerfTest(invocations = 1000, threads = 20, duration=2000)   //PerfTest convierte un JUnit en una prueba Contiperf. A definir número de iteraciones y los hilos que se disponen
	@Required(max = 3000, average = 2000, median=2000)  //Required define las requisitos de rendimiento, si no los cumple --> rojo
	public void cambiarContraTest() throws Exception {
		Thread.sleep(1000);		
	}
	
	@Test
	@PerfTest(invocations = 1000, threads = 20, duration=2000)   //PerfTest convierte un JUnit en una prueba Contiperf. A definir número de iteraciones y los hilos que se disponen
	@Required(max = 3000, average = 2000, median=2000)  //Required define las requisitos de rendimiento, si no los cumple --> rojo
	public void cfarticuloTest() throws Exception {
		Thread.sleep(1000);	
	}
	
	
	
	@Test
	@PerfTest(invocations = 1000, threads = 20, duration=2000)   //PerfTest convierte un JUnit en una prueba Contiperf. A definir número de iteraciones y los hilos que se disponen
	@Required(max = 3000, average = 2000, median=2000)  //Required define las requisitos de rendimiento, si no los cumple --> rojo
	public void estadisticasTest() throws Exception {
		Thread.sleep(1000);	
	}
	
	@Test
	@PerfTest(invocations = 1000, threads = 20, duration=2000)   //PerfTest convierte un JUnit en una prueba Contiperf. A definir número de iteraciones y los hilos que se disponen
	@Required(max = 3000, average = 2000, median=2000)  //Required define las requisitos de rendimiento, si no los cumple --> rojo
	public void listaquejaTest() throws Exception {
		Thread.sleep(1000);	
	}
	@Test
	@PerfTest(invocations = 1000, threads = 20, duration=2000)   //PerfTest convierte un JUnit en una prueba Contiperf. A definir número de iteraciones y los hilos que se disponen
	@Required(max = 3000, average = 2000, median=2000)  //Required define las requisitos de rendimiento, si no los cumple --> rojo
	public void menuadminTest() throws Exception
	{
		Thread.sleep(1000);
	}
	
	@Test
	@PerfTest(invocations = 1000, threads = 20, duration=2000)   //PerfTest convierte un JUnit en una prueba Contiperf. A definir número de iteraciones y los hilos que se disponen
	@Required(max = 3000, average = 2000, median=2000)  //Required define las requisitos de rendimiento, si no los cumple --> rojo
	public void menuclienteTest() throws Exception
	{
		Thread.sleep(1000);
	}
	
	@Test
	@PerfTest(invocations = 1000, threads = 20, duration=2000)   //PerfTest convierte un JUnit en una prueba Contiperf. A definir número de iteraciones y los hilos que se disponen
	@Required(max = 3000, average = 2000, median=2000)  //Required define las requisitos de rendimiento, si no los cumple --> rojo
	public void menuprinTest() throws Exception
	{
		Thread.sleep(1000);
	}
	
	@Test
	@PerfTest(invocations = 1000, threads = 20, duration=2000)   //PerfTest convierte un JUnit en una prueba Contiperf. A definir número de iteraciones y los hilos que se disponen
	@Required(max = 3000, average = 2000, median=2000)  //Required define las requisitos de rendimiento, si no los cumple --> rojo
	public void modificarcdTest() throws Exception
	{
		Thread.sleep(1000);		
	}
	
	@Test
	@PerfTest(invocations = 1000, threads = 20, duration=2000)   //PerfTest convierte un JUnit en una prueba Contiperf. A definir número de iteraciones y los hilos que se disponen
	@Required(max = 3000, average = 2000, median=2000)  //Required define las requisitos de rendimiento, si no los cumple --> rojo
	public void modificardvdTest() throws Exception
	{
		Thread.sleep(1000);
	}
	
	@Test
	@PerfTest(invocations = 1000, threads = 20, duration=2000)   //PerfTest convierte un JUnit en una prueba Contiperf. A definir número de iteraciones y los hilos que se disponen
	@Required(max = 3000, average = 2000, median=2000)  //Required define las requisitos de rendimiento, si no los cumple --> rojo
	public void modificarlibroTest() throws Exception
	{
		Thread.sleep(1000);
	}
	
	@Test
	@PerfTest(invocations = 1000, threads = 20, duration=2000)   //PerfTest convierte un JUnit en una prueba Contiperf. A definir número de iteraciones y los hilos que se disponen
	@Required(max = 3000, average = 2000, median=2000)  //Required define las requisitos de rendimiento, si no los cumple --> rojo
	public void quejaTest() throws Exception
	{
		Thread.sleep(1000);
	}
	
	@Test
	@PerfTest(invocations = 1000, threads = 20, duration=2000)   //PerfTest convierte un JUnit en una prueba Contiperf. A definir número de iteraciones y los hilos que se disponen
	@Required(max = 3000, average = 2000, median=2000)  //Required define las requisitos de rendimiento, si no los cumple --> rojo
	public void sugerenciaTest() throws Exception
	{
		Thread.sleep(1000);
	}
	
	@Test
	@PerfTest(invocations = 1000, threads = 20, duration=2000)   //PerfTest convierte un JUnit en una prueba Contiperf. A definir número de iteraciones y los hilos que se disponen
	@Required(max = 3000, average = 2000, median=2000)  //Required define las requisitos de rendimiento, si no los cumple --> rojo
	public void verarticuloTest() throws Exception
	{
		Thread.sleep(1000);
		
	}
	
	@Test
	@PerfTest(invocations = 1000, threads = 20, duration=2000)   //PerfTest convierte un JUnit en una prueba Contiperf. A definir número de iteraciones y los hilos que se disponen
	@Required(max = 3000, average = 2000, median=2000)  //Required define las requisitos de rendimiento, si no los cumple --> rojo
	public void botonesTest() throws Exception
	{
		Thread.sleep(1000);
	}
	
}

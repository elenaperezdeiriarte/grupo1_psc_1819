package com.eLibrary;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import LDProyecto.ClsDatos;
import LNProyecto.ClsArticulo;
import LNProyecto.ClsBloqueo;
import LNProyecto.ClsCD;
import LNProyecto.ClsComentario;
import LNProyecto.ClsConstantes.enFicDatos;
import LNProyecto.ClsContrasena;
import LNProyecto.ClsQuejas;
import LNProyecto.ClsSugerencias;
import LNProyecto.ClsUnificadorDClases;
import LNProyecto.MiExcepcion;

public class unificadorTest {
	ClsUnificadorDClases uni = new ClsUnificadorDClases();
	ArrayList<ClsArticulo> arti;
	ArrayList<ClsSugerencias> sug;
	ArrayList<ClsQuejas> quej;
	ArrayList<ClsComentario> com;
	ClsArticulo a;
	ClsDatos dat;
	ClsBloqueo bloc;
	ClsContrasena con;
	enFicDatos fic;
	
	@Test
	public void numeradortest() {
		int num = uni.leerNumerador();
		assertNotNull(num);
	}
	
	@Test
	public void sumanumtest() {
		uni.sumarNumerador();
	}
	
	
	
	/*@Test
	public void guardarcdtest() throws MiExcepcion
	{
		uni.NuevoCD(null, 0, null, 0, 0, 0, 0, 0, 0, 0, null, null);
	}
	
	@Test
	public void guardardvdtest() throws MiExcepcion
	{
		uni.NuevoDVD(null, 0, null, 0, 0, 0, 0, 0, 0, 0, 1, null, null);
	}
	
	@Test
	public void guardarlibrotest() throws MiExcepcion
	{
		uni.NuevoLibro(null, 0, null, 0, 0, 0, 0, 0, 2, null, null);
	}*/
	
	@Test
	public void artitest() {
		arti = uni.leerArticulos();		
		uni.guardarArticulos(arti);		
		assertNotNull(arti);
		
		
	}
	
	@Test
	public void comenttest() {
		com = uni.leerComentarios();
		uni.guardarComentario(com);
		uni.NuevoComentario(null, 0);
		assertNotNull(com);		
	}
	
	
	@Test
	public void sugetest() {
		sug = uni.leerSugerencias();
		uni.NuevaSugerencia(null, null, null);
		uni.guardarSugerencias(sug);		
		assertNotNull(sug);
	}
	
	@Test
	public void quejtest() {
		quej = uni.leerQuejas();		
		uni.NuevaQueja(null);		
		uni.guardarQuejas(quej);
		assertNotNull(quej);
	}
	
	//@Test
	/*public void moditest() throws MiExcepcion {
		uni.comenzarModificacion(a);		
		uni.Modificar(a, 0, 0, null, null);
	}*/
	
	@Test
	public void contratest()  {
		con = new ClsContrasena("password");
		uni.guardarContra(con);
		String cont = uni.leerContra();
		assertNotNull(cont);
	}
	
	@Test
	public void bloquetest()  {
		
		ClsBloqueo b = new ClsBloqueo();
		uni.guardarBloqueo(b);
		bloc = uni.leerBloqueo();
		
		int intentos = uni.intentosBloqueo();
		//int semaforo = uni.semaforoBloqueo();
		
		assertNotNull(bloc);
		//assertNotNull(semaforo);
		assertNotNull(intentos);
	}
	
	@Test
	public void intentostest()  {
		uni.reiniciarIntentos();
		uni.sumarIntento();
		int intentos = uni.getIntentos();
		assertNotNull(intentos);
	}
	
	@Test
	public void minutotest()  {
		uni.sacarMinutos();
	}
	
	/*@Test
	public void faltatest()  {
		uni.sacarFalta();
	}*/
	
	@Test
	public void eliminarfictest()  {
		//uni.eliminarFichero(fic);
		uni.eliminarSugerencias();
		uni.eliminarQuejas();
	}
	@Test
	public void eliminarsugtest()  {
		uni.eliminarSugerencias();
	}
	
	@Test
	public void eliminarquejtest()  {
		uni.eliminarQuejas();
	}
	
	@Test
	public void leercomenttest()  {
		com = uni.leerComentariosArticulo(0);
		assertNotNull(com);
	}
	
	@Test
	public void sabercomenttest()  {
		boolean bo = uni.saberSiComentarios(0);
		assertNotNull(bo);
	}
	
	@Test
	public void tamanostest()  {
		ArrayList<Integer> tam = uni.tamanosColumnas();
		assertNotNull(tam);
	}
	
	
	
	
	
	
}

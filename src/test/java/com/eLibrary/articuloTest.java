package com.eLibrary;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import LNProyecto.ClsArticulo;

public class articuloTest {
	ClsArticulo nuevoArt = new ClsArticulo(4, "Julen", "La casa azul", 5, 1, 7, 9, 0, null, null);
	@Test
	public void test() {
		
		assertNotNull(nuevoArt);
		
		ClsArticulo mismoArt = nuevoArt;
		int comparacion = mismoArt.compareTo(nuevoArt);
		assertEquals(0,comparacion);
		
		int votos = nuevoArt.getNumVotos();
		assertNotNull(votos);
		
		int nota = (int) nuevoArt.getNota();
		assertEquals(5, nota);
		
		int estado = nuevoArt.getEstado();
		assertNotNull(estado);
		
		int contador = nuevoArt.getContador();
		assertNotNull(contador);
		
		String nombre = nuevoArt.getNombre();
		assertEquals("Julen", nombre);
		
		String autor = nuevoArt.getAutor();
		assertNotNull(autor);
		
		int numero = nuevoArt.getNumero();
		assertEquals(4,numero);
		
		String toString = nuevoArt.toString();
		assertNotNull(toString);
	}
	
	@After
	public void otroTest()
	{
		int respuesta = nuevoArt.cambiarNumero(7);
		assertEquals(0, respuesta);
		
	}

}

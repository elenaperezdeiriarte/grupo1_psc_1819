package com.eLibrary;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import LDProyecto.BaseDatos;
import LNProyecto.ClsCD;

public class adrianTest {
	ClsCD cdnuevo = new ClsCD("Zapatillas", 1, "El canto del loco", 120, 2005,
			7.0, 0, 3, 5, 0, "www.elcantodelloco,con/zapatillas.html", "www.elcantodelloco.com/imagen.png");
	@Test
	public void test() {
		
		assertNotNull(cdnuevo);
		
		BaseDatos.initBD("eLibraryTest.db");
		BaseDatos.eliminarTablaBDCD();
		BaseDatos.crearTablaBDCD();
		
		try {
			BaseDatos.crearCD(BaseDatos.getStatement(), cdnuevo);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		BaseDatos.close();
		
		ClsCD CDenBD = new ClsCD("", 0, "", 0, 0,
				0, 0, 0, 0, 0, "", "");
		BaseDatos.initBD("eLibraryTest.db");
		BaseDatos.crearTablaBDCD();
		try {
			CDenBD = BaseDatos.returnCD(1);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		BaseDatos.close();
		
		int comparacion = CDenBD.compareTo(cdnuevo);
		assertEquals(0,comparacion);
				
		int nota = (int) CDenBD.getNota();
		assertEquals(7, nota);
		
		int votos = CDenBD.getNumVotos();
		assertEquals(5, votos);
		
		int estado = CDenBD.getEstado();
		assertEquals(0, estado);
		
		int contador = CDenBD.getContador();
		assertEquals(3,contador);
		
		String nombre = CDenBD.getNombre();
		assertEquals("Zapatillas", nombre);
		
		String autor = CDenBD.getAutor();
		assertEquals("El canto del loco",autor);
		
		int numero = CDenBD.getNumero();
		assertEquals(1,numero);
		
		String toString = CDenBD.toString();
		assertNotNull(toString);
	}
}

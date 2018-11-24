package com.eLibrary;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import LDProyecto.BaseDatos;
import LNProyecto.ClsQuejas;
import LNProyecto.ClsSugerencias;

public class mikelTest {
	ClsSugerencias sugerencia = new ClsSugerencias("El Mal Querer", "Rosalia", "CD");
	@Test
	public void test() {
		assertNotNull(sugerencia);
		
		BaseDatos.initBD("eLibraryTest.db");
		BaseDatos.eliminarTablaBDS();
		BaseDatos.crearTablaBDS();
		try {
			BaseDatos.crearSugerencia(BaseDatos.getStatement(),sugerencia.getNombre(), sugerencia.getAutor(),sugerencia.getTipo());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		BaseDatos.close();
		
		ArrayList<ClsSugerencias> arraySugerencias = new ArrayList<ClsSugerencias>();
		
		BaseDatos.initBD("eLibraryTest.db");
		BaseDatos.crearTablaBDS();
		try {
			BaseDatos.selectSugerencias();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		arraySugerencias = BaseDatos.getSugerencias();
		BaseDatos.close();
		
		ClsSugerencias SugerenciaenBD = arraySugerencias.get(0);
		
		String autor = SugerenciaenBD.getAutor();
		assertEquals("Rosalia",autor);		
		
		String nombre = SugerenciaenBD.getNombre();
		assertEquals("El Mal Querer",nombre);		
		
		String tipo = SugerenciaenBD.getTipo();
		assertEquals("CD",tipo);		
		
		}

}

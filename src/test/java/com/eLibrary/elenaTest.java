package com.eLibrary;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import LDProyecto.BaseDatos;
import LNProyecto.ClsQuejas;

public class elenaTest {
	ClsQuejas queja = new ClsQuejas("Somos unos vividores");
	@Test
	public void test() {
		assertNotNull(queja);
		
		BaseDatos.initBD("eLibraryTest.db");
		BaseDatos.eliminarTablaBDQ();
		BaseDatos.crearTablaBDQ();
		try {
			BaseDatos.crearQueja(BaseDatos.getStatement(), queja.getQueja());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		BaseDatos.close();
		
		ArrayList<ClsQuejas> arrayQuejas = new ArrayList<ClsQuejas>();
		
		BaseDatos.initBD("eLibraryTest.db");
		BaseDatos.crearTablaBDQ();
		try {
			BaseDatos.selectQuejas();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		arrayQuejas = BaseDatos.getQuejas();
		BaseDatos.close();
		
		ClsQuejas QuejaenBD = arrayQuejas.get(0);
		
		String texto = QuejaenBD.getQueja();
		assertEquals("Somos unos vividores",texto);		
		
		}

}
